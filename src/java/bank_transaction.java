

import controller.GameStatus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m.JDBC;


@WebServlet(urlPatterns = {"/bank_transaction"})
public class bank_transaction extends HttpServlet {

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
            try {
                String name = request.getSession().getAttribute("un").toString();
                ResultSet rset = new JDBC().getData("select * from bank_transaction where name = '" + name + "'");
                out.print("<table class=\"table table-striped\">\n"
                        + "                        <thead>\n"
                        + "                            <tr>\n"
                        + "                                <th>Type</th>\n"
                        + "                                <th>amount</th>\n"
                        + "                            </tr>\n"
                        + "                        </thead>\n"
                        + "                        <tbody>\n");
                while (rset.next()) {
                    out.print("                            <tr>\n"
                            + "                                <td>" + rset.getString(3) + "</td>\n"
                            + "                                <td>" + rset.getDouble(4) + "</td>\n"
                            + "                            </tr>\n");
                }
                out.print("                        </tbody>\n"
                        + "                    </table>");
            } catch (Exception e) {
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
