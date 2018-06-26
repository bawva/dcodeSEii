

import controller.Broker;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m.JDBC;


@WebServlet(urlPatterns = {"/purchase"})
public class purchase extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            boolean bool = false;
            String stockShortName = null;
            String stockName = null;
            String name = request.getSession().getAttribute("un").toString();
            String stock = request.getParameter("stock_id");
            String price = request.getParameter("price");
            String qty = request.getParameter("qty");
            String type = request.getParameter("tradeType");
            try {
                ResultSet rset = new JDBC().getData("select * from stock_values where id = '" + stock + "'");
                if (rset.next()) {
                    stockShortName = rset.getString(2);
                    stockName = rset.getString(3);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            Broker broker = new Broker();
            if (Integer.parseInt(type) == 1) {
                out.write(qty + " " + price + " " + stock + " " + name);
                bool = broker.buy(name, Integer.parseInt(stock), Integer.parseInt(qty), Double.parseDouble(price));
                try {
                    new JDBC().putData("insert into transaction_history(symbol,stock_name.price,qty,type) values('" + stockShortName + "','" + stockName + "','" + price + "','" + qty + "','" + "Buy" + "','" + name + "')");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                broker.sell(name, Integer.parseInt(stock), Integer.parseInt(qty), Double.parseDouble(price));
                try {
                    new JDBC().putData("insert into transaction_history(symbol,name.price,qty,type) values('" + stockShortName + "','" + stockName + "','" + price + "','" + qty + "','" + "Sell" + "','" + name + "')");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (bool) {
                response.sendRedirect("gameBoard.jsp");
//                out.write("OK");
            } else {
//                out.write("NO");
                response.sendRedirect("portfolio.jsp");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
