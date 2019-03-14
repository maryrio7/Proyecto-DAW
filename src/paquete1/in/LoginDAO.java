package paquete1.in;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	LoginDAO(){	}
	
	public String loginCheck(LoginBean bean) {
		Connection con = MyConnection.getConnection();
		String email = bean.getEmail();
		String pword = bean.getPword();
		String newPword = bean.getNewPword();
		
		try {
			String sqlQuery = "select * from usertable where email=? and pword=? and active=1";
			PreparedStatement pst = con.prepareStatement(sqlQuery);
			pst.setString(1, email);
			pst.setString(2, newPword);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String dbemail = rs.getString("email");
				String dbpword = rs.getString("pword");
				if(dbemail.equalsIgnoreCase(email) && 
					dbpword.equalsIgnoreCase(newPword)) {
					return "success";
				}
				return "error";
			}
			
		} catch(Exception ex) {
			System.out.println("LoginDAO: "+ex);
		}
		return "error";
	}
}
