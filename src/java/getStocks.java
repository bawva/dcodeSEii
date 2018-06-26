
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


@WebServlet(urlPatterns = {"/getStocks"})
public class getStocks extends HttpServlet {

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
            Game gg = Game.getInstance();
            if (GameStatus.gameStatus == 0) {
                gg.startGame();
//                gg.init();
                System.out.println("starting game");
            }
            if (GameStatus.gameStatus == 10) {
                response.sendRedirect("selectWinner");
            }

            try {
                out.print("<div class=\"form-group\">\n"
                        + "                            <label for=\"exampleInputEmail1\"> Turn :" + (GameStatus.turn + 1) + "</label>\n"
                        + "                        </div>");
                ResultSet stockResult = new JDBC().getData("select * from stock_values");
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
                    if (GameStatus.turn < 10) {
                        //075 55 71 098 031 37 19 655
                        out.print("                            <tr>\n"
                                + "                                <td>" + stockResult.getString(2) + "</td>\n"
                                + "                                <td>" + stockResult.getString(3) + "</td>\n"
                                + "                                <td>" + GameStatus.a1[stockResult.getInt(1) - 1][GameStatus.turn] + "</td>\n"
                                + "                                <td><button onclick=\"loadPrice('" + stockResult.getString(1) + "','" + stockResult.getString(2) + "','" + stockResult.getString(3) + "','" + GameStatus.a1[stockResult.getInt(1) - 1][GameStatus.turn] + "')\"; \" class='btn btn-outline-success btn-sm' data-toggle='modal' data-target='#trade'>Buy</button></td>\n"
                                + "                            </tr>\n");
                    }
                }
                out.print("                        </tbody>\n"
                        + "                    </table>");
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
