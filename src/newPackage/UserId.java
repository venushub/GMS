package newPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class UserId {

	public int getUserId() {
		
		int maxID = 0;
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("Select MAX(user_id) from Grievance.user_main");
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
	
	public String registerNewUser(int uid, String name, String email,String pswd, Timestamp tmstmp){
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query = "INSERT INTO Grievance.user_main(user_id,user_name,user_email,user_password,gr_time_stamp) VALUES(?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, uid);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, pswd);
			stmt.setTimestamp(5, tmstmp);
			stmt.executeUpdate();
		    con.close();
		    return "User registered Successfully";
			} catch (SQLException e) {
		        System.out.println(e);
		        return "Cannot register user";
			}
	}
	
	public String getUserNameForSession(String usrname){
		
		String dbusername = new String();
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
			String query = "SELECT user_name FROM Grievance.user_main WHERE user_email=?";
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, usrname);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				dbusername = rs.getString(1);
			}
		    con.close();
			} catch (SQLException e) {
		        System.out.println(e);
			}
		return dbusername;
	}
	
}
