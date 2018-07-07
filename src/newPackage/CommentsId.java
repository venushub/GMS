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
	
	public ArrayList<String> getComments(int grid){
		
		ArrayList<String> lista = new ArrayList<String>();
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query = "Select comment_msg FROM Grievance.grievance_comments WHERE gr_id="+grid;
			PreparedStatement stmt1=con.prepareStatement(query);
			ResultSet rs = stmt1.executeQuery();
			System.out.println(rs);
			while(rs.next()){
				lista.add(rs.getString(1).toString());
			}
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		return lista ;
		
	}
}
