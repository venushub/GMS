package adminPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/admindatamgmt")
public class AdminDataManagementServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);
		if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){
			request.getRequestDispatcher("/WEB-INF/AdminDataManagement.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
/*		request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
*/	}
}