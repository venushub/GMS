package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCheck {
	
	public String checkUserinDatabase(String un, String pswd ) {
		
		String bo = new String("FALSE");
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			/*String query = "SELECT user_email FROM Grievance.user_main WHERE user_email =" + "'" +un+ "'" +  "AND user_password="   + "'" +   pswd +"'"+ ""    ;
			*/
			String query = "SELECT user_email FROM Grievance.user_main WHERE user_email = ? AND user_password= ?" ;
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, un);
			stmt.setString(2, pswd);
			ResultSet rs = stmt.executeQuery();	
			if(rs.next()){
				bo = "TRUE" ; 
			} else {
				bo = "FALSE";
			}
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		
		
		return bo;
		
	}
	
	
public String checkUserinDatabase(String un) {
		
		String bo = new String("FALSE");
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			/*String query = "SELECT user_email FROM Grievance.user_main WHERE user_email =" + "'" +un+ "'" +  "AND user_password="   + "'" +   pswd +"'"+ ""    ;
			*/
			String query = "SELECT user_email FROM Grievance.user_main WHERE user_email = ?" ;
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, un);
			ResultSet rs = stmt.executeQuery();	
			if(rs.next()){
				bo = "TRUE" ; 
			} else {
				bo = "FALSE";
			}
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		
		
		return bo;
		
	}
	
}
