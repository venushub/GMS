package newPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CheckMappingC2A {

public String checkMapping(String cat_name, String agent_name) {
		
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
			String query3 = "SELECT * FROM Grievance.map_main WHERE (category_name, user_email) IN ((? , ?))";
			
			PreparedStatement stmt=con.prepareStatement(query3);
			stmt.setString(1, cat_name);
			stmt.setString(2, agent_name);
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


	public ArrayList<String> getMappingsForAgent(String agentemail){
		
		ArrayList<String> arl = new ArrayList<String>();
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			/*String query = "SELECT user_email FROM Grievance.user_main WHERE user_email =" + "'" +un+ "'" +  "AND user_password="   + "'" +   pswd +"'"+ ""    ;
			*/
			String query4 = "SELECT category_name FROM Grievance.map_main WHERE  user_email = ?";
			
			PreparedStatement stmt4=con.prepareStatement(query4);
			
			stmt4.setString(1, agentemail);
			
			ResultSet rs = stmt4.executeQuery();	
			while(rs.next()){
				arl.add(rs.getString(1).toString());
			}
			con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
			return arl;
	}
}
	