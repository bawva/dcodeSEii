
import controller.Game;
import controller.GameStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m.JDBC;


@WebServlet(urlPatterns = {"/buyTransaction"})
public class buyTransaction extends HttpServlet {

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
            Game gg = Game.getInstance();
            String name = request.getSession().getAttribute("un").toString();
            try {
                ResultSet stockResult = new JDBC().getData("select * from transaction where type = '" + 1 + "' and name = '" + name + "' and qty>0");

                out.print("<table class=\"table table-striped\">\n"
                        + "                        <thead>\n"
                        + "                            <tr>\n"
                        + "                                <th>Symbol</th>\n"
                        + "                                <th>Name</th>\n"
                        + "                                <th>Price</th>\n"
                        + "                                <th>Trade</th>\n"
                        + "                            </tr>\n"
                        + "                        </thead>\n"
                        + "                        <tbody>\n");
                while (stockResult.next()) {
                    out.print(GameStatus.turn);
                    ResultSet stock_details = new JDBC().getData("select * from stock_values where id = '" + stockResult.getInt(6) + "'");
                    if (stock_details.next()) {
                        out.print("                            <tr>\n"
                                + "                                <td>" + stock_details.getString(2) + "</td>\n"
                                + "                                <td>" + stock_details.getString(3) + "</td>\n"
                                + "                                <td>" + stockResult.getString(4) + "</td>\n"
                                + "                                <td>" + GameStatus.a1[stockResult.getInt(6) - 1][GameStatus.turn] + "</td>\n"
                                + "                                <td>" + stockResult.getString(5) + "</td>\n"
                                + "                                <td>" + stockResult.getDouble(5) * stockResult.getDouble(4) + "</td>\n"
                                + "                                <td><button onclick=\"loadPrice('" + stockResult.getString(1) + "','" + stock_details.getString(2) + "','" + stock_details.getString(3) + "','" + GameStatus.a1[stockResult.getInt(6) - 1][GameStatus.turn] + "')\"; \" class='btn btn-outline-success btn-sm' data-toggle='modal' data-target='#trade'>Sell</button></td>\n"
                                + "                            </tr>\n");
                    }
                }
                out.print("                        </tbody>\n"
                        + "                    </table>");
                // (stockResult.getInt(4) + (gg.a1[GameStatus.turn][stockResult.getInt(1) - 1]))
            } catch (Exception ex) {
                Logger.getLogger(getStocks.class.getName()).log(Level.SEVERE, null, ex);
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
