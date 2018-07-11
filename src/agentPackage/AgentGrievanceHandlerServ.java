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
import newPackage.GrievanceHandle;


@WebServlet(urlPatterns= "/agentaction")
public class AgentGrievanceHandlerServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession sesh = request.getSession(false);

	if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("agent")){
	
	String comment = request.getParameter("grievancecomment");

	String userrole = "agent";
	
	String useremail = sesh.getAttribute("useremail").toString();
	String grid = request.getParameter("grid");
	int gr_id = Integer.parseInt(grid);
	
	GrievanceHandle gh = new GrievanceHandle();
	gh.addComment(comment, useremail, userrole, gr_id);
	
	String redirectpage = "agentgrievancedetail?gr_id="+grid;
	
	
	
	
	response.sendRedirect(redirectpage);
	} else {
		response.sendRedirect("login");
	}
	
	}
}
