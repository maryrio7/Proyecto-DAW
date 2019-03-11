package paquete1.in;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pword = request.getParameter("pword");
			String newPword = DigestUtils.md5Hex(pword);
			
			//Generacion del codigo Hash para el link de verificación
			String myHash;
			Random random = new Random();
			random.nextInt(999999);
			myHash = DigestUtils.md5Hex(""+random);
			
			//Data Bean
			RegisterBean rb = new RegisterBean();
			rb.setFname(fname);
			rb.setLname(lname);
			rb.setEmail(email);
			rb.setPword(newPword);
			rb.setMyhash(myHash);
			
			//Creacion DAO File
			RegisterDAO regDao = new RegisterDAO();
			String str = regDao.RegisterUser(rb);
			if (str.equals("SUCCESS")) {
				response.sendRedirect("verify.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
			
		} catch(Exception ex) {
			System.out.println("RegisterDAO File: "+ex);
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
