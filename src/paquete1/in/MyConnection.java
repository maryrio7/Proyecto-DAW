package paquete1.in;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("con.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/email_validation","root","");
		} catch(Exception ex) {
			System.out.println("From MyConnection Class "+ex);
		}
		return con;
	}
}
