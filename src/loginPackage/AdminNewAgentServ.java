package loginPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/adminaddagent")
public class AdminNewAgentServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession(false);

		if( sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("admin")){

		
		/*		session.setAttribute("username", username);
		session.setAttribute("useremail", useremail);*/
       /* for(int i=1;i<10;i++){
		ArrayList<String> row = new ArrayList<String>();
		row.add("one");
		row.add("two");
		row.add("three");
		row.add("four");
		tableelems.add(row);
		}*/
		
			request.getRequestDispatcher("/WEB-INF/AdminUserCreateNewAgent.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}
}