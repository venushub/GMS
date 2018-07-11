package staticPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import newPackage.CategoryId;

public class CategoryData {
	
	public ArrayList<String> getCategoryData(){
		
		ArrayList<String> catlist = new ArrayList<String>();

		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			/*String query = "INSERT INTO Grievance.grievance_main(gr_id,user_id,gr_type,gr_msg,gr_time_stamp) VALUES("+ gr_id + "," + userid + "," +"'"+ category+"'"+"," +"'"+ grievancenote +"'"+","+"'"+ localDate+"'"+")";
			*/
			String query1 = "SELECT category_name FROM Grievance.category_main";
			PreparedStatement prstmt = con.prepareStatement(query1);
			ResultSet rs  = prstmt.executeQuery();
			
			while(rs.next()){
				
				catlist.add(rs.getString("category_name"));
				
			}
			
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}

			return catlist ;
	}
	
	public void addCategory(String category, String useremail){
		
		
		
		CategoryId catid =  new CategoryId();
		int categoryid = ((catid.getCategoryId()) + 1);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			/*String query = "INSERT INTO Grievance.grievance_main(gr_id,user_id,gr_type,gr_msg,gr_time_stamp) VALUES("+ gr_id + "," + userid + "," +"'"+ category+"'"+"," +"'"+ grievancenote +"'"+","+"'"+ localDate+"'"+")";
			*/
			String query = "INSERT INTO Grievance.category_main(category_id, category_name, user_email, created_time_stamp) VALUES(?,?,?,?)";
			PreparedStatement prstmt = con.prepareStatement(query);
			prstmt.setInt(1, categoryid);
			prstmt.setString(2, category);
			prstmt.setString(3, useremail);
			prstmt.setTimestamp(4, timestamp);
			prstmt.executeUpdate();
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}

	}

}
