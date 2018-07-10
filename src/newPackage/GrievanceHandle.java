package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import newPackage.CommentsId;

public class GrievanceHandle {
	
	
	public void addComment(String comment, String agentuser, int gr_id ) {
		
		
		CommentsId cid = new CommentsId();
		
		int comid = cid.getCommentId();
		comid = comid + 1 ;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query1 = "INSERT INTO Grievance.grievance_comments(comment_id,gr_id,user_email,user_role,comment_msg,comment_time_stamp) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt1=con.prepareStatement(query1);
			stmt1.setInt(1, comid);
			stmt1.setInt(2, gr_id);
			stmt1.setString(3, agentuser);
			stmt1.setString(4, "agent");
			stmt1.setString(5, comment);
			stmt1.setTimestamp(6, timestamp);
			stmt1.executeUpdate();
			
			
			
			String query2 = "UPDATE Grievance.grievance_main SET agent_status = ? , user_status = ? WHERE gr_id = ?";
			PreparedStatement stmt2=con.prepareStatement(query2);
			stmt2.setString(1, "commented");
			stmt2.setString(2, "commented");
			stmt2.setInt(3, gr_id);
			stmt2.executeUpdate();
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
}
	
}
