package paquete1.in;

import paquete1.in.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegisterDAO {
	
	public RegisterDAO() {}
	
	public String RegisterUser (RegisterBean rb) {
		String fname = rb.getFname();
		String lname = rb.getLname();
		String email = rb.getEmail();
		String pword = rb.getPword();
		String myhash = rb.getMyhash();
		
		Connection con = MyConnection.getConnection();
		try {
			String sqlQuery = "insert into usertable (fname,lname,email,pword,hash) values (?,?,?,?,?)";
			PreparedStatement pat = con.prepareStatement(sqlQuery);
			pat.setString(1, fname);
			pat.setString(2, lname);
			pat.setString(3, email);
			pat.setString(4, pword);
			pat.setString(5, myhash);
			
			int i = pat.executeUpdate();
			if (i!=0) {
				//Envío de codigo al email
				SendingEmail se = new SendingEmail(email, myhash);
				se.sendMail();
				return "SUCCESS";
			}
		}catch(Exception ex) {
			System.out.println("RegisterDAO File "+ex);
		}
		
		return "error";
	}
}
