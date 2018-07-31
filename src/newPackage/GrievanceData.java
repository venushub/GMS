package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class GrievanceData {
	
	String user_email = new String();
	String gr_type = new String();
	String gr_msg = new String();
/*	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
*/	String timestamp = new String();
	String status = new String();
	int status_weight;
	
	public String get_user_email(){
		return user_email;
	}
	
	public String get_gr_type(){
		return gr_type;
	}

	public String get_gr_msg(){
		return gr_msg;
	}

	public String get_timestamp(){
		return timestamp;
	}

	public String get_status(){
		return status;
	}
	
	public int get_status_weight(){
		return status_weight;
	}
	
	public void getSetGrievanceData(int grid) {	
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query = "Select user_email, gr_type, gr_msg, gr_time_stamp, status, status_weight FROM Grievance.grievance_main WHERE gr_id="+grid;
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			while(rs.next()){
				user_email = rs.getString(1).toString();	
				gr_type = rs.getString(2).toString();
				gr_msg = rs.getString(3).toString();
				timestamp = rs.getTimestamp(4).toString();
				status = rs.getString(5).toString();
				status_weight = rs.getInt(6);
			}
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
	}
}
