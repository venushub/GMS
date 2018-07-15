package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserData {

	public ArrayList<String> getUserData(String usertype){
		
		ArrayList<String> al = new ArrayList<String>();
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query = "Select user_email FROM Grievance.user_main WHERE user_role="+usertype;
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			while(rs.next()){
				al.add(rs.getString(1).toString());
			}
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		return al;
	}
}
