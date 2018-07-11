package basePackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import staticPackage.CategoryData;

@WebServlet("/newgrievance")
public class NewGrievanceServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		session.getAttribute("username", "venu");*/
/*		request.setAttribute("username", "venu");
		request.setAttribute("userid", "1234");*/
		
		HttpSession sesh = request.getSession(false);
		if( sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("customer")){

		CategoryData catdata  = new CategoryData();
		
		ArrayList<String> catlist = catdata.getCategoryData();
		
		request.setAttribute("categories", catlist);
			request.getRequestDispatcher("/WEB-INF/newgrievance.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
	}
}