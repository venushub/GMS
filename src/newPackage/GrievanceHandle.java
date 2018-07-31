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
	
	
	public void addComment(String comment, String agentuser, String userrole ,int gr_id , String action, String prevstatus, int prevstatusweight) {
		
		
		CommentsId cid = new CommentsId();
		
		int comid = cid.getCommentId();
		comid = comid + 1 ;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String comment_type;
		
		
		
		if(action.equals("comment")){
			comment_type = "normal";
		} else if (action.equals("close")) {
			comment_type = "closed";
		} else {
			comment_type = "reopen";
		}
		
		
		
	
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query1 = "INSERT INTO Grievance.grievance_comments(comment_id,gr_id,user_email,user_role,comment_type,comment_msg,comment_time_stamp) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement stmt1=con.prepareStatement(query1);
			stmt1.setInt(1, comid);
			stmt1.setInt(2, gr_id);
			stmt1.setString(3, agentuser);
			
			if(userrole.equals("agent")){
			stmt1.setString(4, "agent");
			} else {
				stmt1.setString(4, "customer");
			}
			
			stmt1.setString(5, comment_type);
			stmt1.setString(6, comment);
			stmt1.setTimestamp(7, timestamp);
			stmt1.executeUpdate();
			
			
		
			String query2 = "UPDATE Grievance.grievance_main SET status = ? , status_weight = ? WHERE gr_id = ?";
			PreparedStatement stmt2=con.prepareStatement(query2);
			
			
			if(userrole.equals("agent")){
				
				
				if(prevstatus.equals("open")){
					
					if(action.equals("comment")){
						stmt2.setString(1, "commented");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
					if(action.equals("close")){
						stmt2.setString(1, "closed");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
				} else if(prevstatus.equals("commented")){
					
					if(action.equals("comment")){
						stmt2.setString(1, "commented");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
					if(action.equals("close")){
						stmt2.setString(1, "closed");
						stmt2.setInt(2, prevstatusweight+1);
					}
				} else if(prevstatus.equals("reopen")) {
					
					if(action.equals("comment")){
						stmt2.setString(1, "commented");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
					if(action.equals("close")){
						stmt2.setString(1, "closed");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
				} else {
					
					
					
				}	
			}
			
			if(userrole.equals("customer")){
					
					
				if(prevstatus.equals("open")){
					if(action.equals("comment")){
						stmt2.setString(1, "open");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
				} else if(prevstatus.equals("commented")){
					
					if(action.equals("comment")){
						stmt2.setString(1, "open");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
				} else if(prevstatus.equals("reopen")) {
					
					if(action.equals("comment"))
					{
						stmt2.setString(1, "reopen");
						stmt2.setInt(2, prevstatusweight+1);
					}
							
				} else if(prevstatus.equals("closed")){
					
					if(action.equals("reopen"))
					{
						stmt2.setString(1, "reopen");
						stmt2.setInt(2, prevstatusweight+1);
					}
					
				}	else {
					
					
					
					
					if(action.equals("comment"))
					{
						stmt2.setString(1, "reopen");
						stmt2.setInt(2, prevstatusweight+1);
					}
				}
			}
			
			stmt2.setInt(3, gr_id);
			stmt2.executeUpdate();
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
}
	
}
