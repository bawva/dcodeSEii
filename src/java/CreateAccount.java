
import controller.Bank;
import controller.Broker;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m.JDBC;


@WebServlet(urlPatterns = {"/CreateAccount"})
public class CreateAccount extends HttpServlet {

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
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastname");
            String eMail = request.getParameter("eMail");
            String password = request.getParameter("password");
            Broker broker = new Broker();
            boolean bool1 = broker.createAccount(firstName);
            if (bool1) {
                try {
                    new JDBC().putData("insert into user_account values('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + firstName + "')");
                } catch (Exception e) {
                }
            } else {
                out.print("<script>alert('This user name is allready exits.')</script>");
            }
            Bank bank = new Bank();
            boolean bool2 = bank.createAccount(firstName);
            if (bool2) {
                try {
                    new JDBC().putData("insert into bank values('" + firstName + "','" + 1000.00 + "')");
                } catch (Exception e) {
                }
            } else {
                out.print("<script>alert('Can't create a bank acount for this name.')</script>");
            }
            if (bool1 && bool2) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("CreateAccount.jsp?msg='This name is allready exits. Please try another.");
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
