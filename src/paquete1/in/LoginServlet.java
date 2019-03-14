package paquete1.in;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Datos recibidos desde login.jsp
			String email = request.getParameter("email");
			String pword = request.getParameter("pword");
			
			String newPword = DigestUtils.md5Hex(pword);
			
			LoginBean bean = new LoginBean();
			bean.setPword(pword);
			bean.setEmail(email);
			bean.setNewPword(newPword);
			
			LoginDAO loginDAO = new LoginDAO();
			String daoString = loginDAO.loginCheck(bean);
			if (daoString.equals("success")){
				HttpSession session = request.getSession(true);
				session.setAttribute("session_user", email);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} catch(Exception ex) {
			System.out.println("Login Servlet: "+ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
