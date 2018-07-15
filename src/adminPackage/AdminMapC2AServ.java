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



@WebServlet("/adminmapC2A")
public class AdminMapC2AServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		
		if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){
		CategoryData catdata = new CategoryData();
		ArrayList<String> categories = catdata.getCategoryData();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/WEB-INF/AdminMapC2A.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
/*		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
*/	}
}