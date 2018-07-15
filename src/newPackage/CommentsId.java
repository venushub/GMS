package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommentsId {
	
public int getCommentId() {
		
		int maxID = 0;
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("Select MAX(comment_id) from Grievance.grievance_comments");
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
	

public ArrayList<ArrayList> getComments(int grid){
	
	
	ArrayList<ArrayList> commentelems = new ArrayList<ArrayList>();
	
	try {
           Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
           System.out.println("Class not found " + e);
    }
	
	try {
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
		String query = "Select comment_id, user_email, user_role,comment_type ,comment_msg, comment_time_stamp FROM Grievance.grievance_comments WHERE gr_id="+grid;
		PreparedStatement stmt1=con.prepareStatement(query);
		ResultSet rs = stmt1.executeQuery();
		System.out.println(rs);
		while(rs.next()){
			ArrayList<String> lista = new ArrayList<String>();
			lista.add(rs.getString("comment_id"));
			lista.add(rs.getString("user_email"));
			lista.add(rs.getString("user_role"));
			lista.add(rs.getString("comment_type"));
			lista.add(rs.getString("comment_msg"));
			lista.add(rs.getString("comment_time_stamp"));
			
			commentelems.add(lista);
			
		}
	    con.close();
		} catch (SQLException e) {
	        System.out.println(e);
		}
	return commentelems ;

}
}
