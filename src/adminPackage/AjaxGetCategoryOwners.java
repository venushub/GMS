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
import staticPackage.CategoryData;



@WebServlet("/getowners")
public class AjaxGetCategoryOwners extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		
		if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){
		
			
		String cat_name = request.getParameter("cat_name");
		ArrayList<String> arlst = new ArrayList<String>();
		CategoryData catdata = new CategoryData();
		ArrayList<String> categories = catdata.getCategoryData();		
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
			
			request.setAttribute("selected_cat", cat_name);
			request.setAttribute("owners", arlst);
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/AdminMapC2A.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
/*		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
*/	}
}