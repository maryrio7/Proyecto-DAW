package paquete1.in;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet("/ActivateAccount")
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActivateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");
		
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement pat = con.prepareStatement("SELECT email,hash,active FROM usertable WHERE email=? AND hash=? AND active='0'");
			pat.setString(1, email);
			pat.setString(2, hash);
			ResultSet rs = pat.executeQuery();
			if (rs.next()) {
				PreparedStatement pat1 = con.prepareStatement("UPDATE usertable SET active='1' WHERE email=? AND hash=?");
				pat1.setString(1, email);
				pat1.setString(2, hash);
				int i = pat1.executeUpdate();
				if (i==1) {
					response.sendRedirect("login.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			}
		}catch(Exception ex) {
			System.out.println("ActivateAccount File "+ex);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
