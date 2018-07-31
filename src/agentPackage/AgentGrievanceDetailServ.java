package agentPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import newPackage.GrievanceData;
import newPackage.CommentsId;


@WebServlet(urlPatterns= "/agentgrievancedetail")
public class AgentGrievanceDetailServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	HttpSession sesh = request.getSession(false);
	
	if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("agent")){
	
	String number = request.getParameter("gr_id");
	int grid = Integer.parseInt(number);
	
	GrievanceData gd = new GrievanceData();
	gd.getSetGrievanceData(grid);
	
	CommentsId cid = new CommentsId();
	
	
	
	
	request.setAttribute("useremail", gd.get_user_email());
	request.setAttribute("grtype", gd.get_gr_type());
	request.setAttribute("grmsg", gd.get_gr_msg());
	request.setAttribute("timestamp", gd.get_timestamp());
	request.setAttribute("status", gd.get_status());
	request.setAttribute("statusweight", gd.get_status_weight());
	request.setAttribute("comments", cid.getComments(grid)); //returns arraylist of arraylist of comment data
	request.setAttribute("grid", grid);
	
	
	
	
	
		request.getRequestDispatcher("/WEB-INF/AgentGrievanceDetail.jsp").forward(request, response);
	} else {
		response.sendRedirect("login");
	}
	
	}
}
