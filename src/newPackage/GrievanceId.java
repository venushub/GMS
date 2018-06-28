package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GrievanceId {

	public int getGrievanceId() {
		
		int maxID = 0;
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("Select MAX(gr_id) from Grievance.grievance_main");
			System.out.println(rs);
			
			while(rs.next()){
				maxID = rs.getInt(1);
			}
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		
		System.out.println(maxID);
		return maxID;
	}
	
}
