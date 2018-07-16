package adminPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newPackage.LoginCheck;
import staticPackage.CategoryData;
import newPackage.CheckMappingC2A;



@WebServlet("/addmapc2a")
public class AddMapC2A extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		
		if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){
		
		String cat_name = request.getParameter("selected_cat");
		String agent_name = request.getParameter("agent_name");
		ArrayList<String> arlst = new ArrayList<String>();
		CategoryData catdata = new CategoryData();
		ArrayList<String> categories = catdata.getCategoryData();
		
        LoginCheck lc = new LoginCheck();
        String lcr = lc.checkUserinDatabase(agent_name);
        if(lcr.equals("FALSE")){
            request.setAttribute("error", "email doesn't in our database");
        	request.setAttribute("selected_cat", cat_name);
        	
        	
        	try {
 	           Class.forName("org.postgresql.Driver");
	 	    } catch (ClassNotFoundException e) {
	 	           System.out.println("Class not found " + e);
	 	    }
        	
    		try {
    			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
    /*			String query = "Select user_email FROM Grievance.map_main WHERE (category_name , user_email) IN (" + "'"+cat_name+"'" + " , * )";
    */
    			String query = "Select user_email FROM Grievance.map_main WHERE category_name = " + "'"+cat_name+"'";
    			PreparedStatement stmt=con.prepareStatement(query);
    			ResultSet rs = stmt.executeQuery();
    			System.out.println(rs);
    			while(rs.next()){
    				arlst.add(rs.getString(1).toString());
    			}
    		    con.close();
    			} catch (SQLException e) {
    				
    		        System.out.println(e);
    			}
			request.setAttribute("owners", arlst);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/AdminMapC2A.jsp").forward(request, response);

        	//request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        } else {
        
	        CheckMappingC2A cmc2a = new CheckMappingC2A();
	        String res = cmc2a.checkMapping(cat_name, agent_name);
	        if(res.equals("TRUE")){
	        	
	        	
	        	request.setAttribute("error", "mapping already exists in our database");
	         	request.setAttribute("selected_cat", cat_name);
        	
	        	try {
	  	           Class.forName("org.postgresql.Driver");
	 	 	    } catch (ClassNotFoundException e) {
	 	 	           System.out.println("Class not found " + e);
	 	 	    }
	         	
	     		try {
	     			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
	     /*			String query = "Select user_email FROM Grievance.map_main WHERE (category_name , user_email) IN (" + "'"+cat_name+"'" + " , * )";
	     */
	     			String query = "Select user_email FROM Grievance.map_main WHERE category_name = " + "'"+cat_name+"'";
	     			PreparedStatement stmt=con.prepareStatement(query);
	     			ResultSet rs = stmt.executeQuery();
	     			System.out.println(rs);
	     			while(rs.next()){
	     				arlst.add(rs.getString(1).toString());
	     			}
	     		    con.close();
	     			} catch (SQLException e) {
	     				
	     		        System.out.println(e);
	     			}
         	
	     		request.setAttribute("owners", arlst);
				request.setAttribute("categories", categories);
				request.getRequestDispatcher("/WEB-INF/AdminMapC2A.jsp").forward(request, response);
	        } else {
        
       
	
				try {
			           Class.forName("org.postgresql.Driver");
			    } catch (ClassNotFoundException e) {
			           System.out.println("Class not found " + e);
			    }
		
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
	/*			String query = "Select user_email FROM Grievance.map_main WHERE (category_name , user_email) IN (" + "'"+cat_name+"'" + " , * )";
	*/
				
	
				String query2 = "INSERT INTO Grievance.map_main (category_name , user_email) VALUES ( ?, ?)"; 
				PreparedStatement stmt2=con.prepareStatement(query2);
				stmt2.setString(1, cat_name);
				stmt2.setString(2, agent_name);
				stmt2.executeUpdate();
			
				String query = "Select user_email FROM Grievance.map_main WHERE category_name = " + "'"+cat_name+"'";
				PreparedStatement stmt=con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				System.out.println(rs);
				while(rs.next()){
					arlst.add(rs.getString(1).toString());
				}
			    con.close();
				} catch (SQLException e) {
					
			        System.out.println(e);
				}
			
       
				request.setAttribute("selected_cat", cat_name);
				request.setAttribute("owners", arlst);
				request.setAttribute("categories", categories);
				request.getRequestDispatcher("/WEB-INF/AdminMapC2A.jsp").forward(request, response);
	        }
	        }
		} else {
			response.sendRedirect("login");
		}
/*		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
*/	}
}