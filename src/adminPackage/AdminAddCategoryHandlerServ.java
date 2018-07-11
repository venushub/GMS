package adminPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import staticPackage.CategoryData;



@WebServlet("/adminaddnewcategory")
public class AdminAddCategoryHandlerServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		
		if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){
		
		
		
		String newcategory = request.getParameter("categoryname");
		
		CategoryData catdata = new CategoryData();
		
		catdata.addCategory(newcategory, sesh.getAttribute("useremail").toString());
		
		
			response.sendRedirect("adminaddcategory");
		} else {
			response.sendRedirect("login");
		}
/*		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
*/	}
}