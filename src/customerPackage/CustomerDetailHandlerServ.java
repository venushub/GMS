package customerPackage;

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


@WebServlet(urlPatterns= "/customerdetailaction")
public class CustomerDetailHandlerServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession sesh = request.getSession(false);
	if(  sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("customer")){

	String grid = request.getParameter("grid");
	String comment = request.getParameter("grievancecomment");

	String userrole = "customer";
	int grida = Integer.parseInt(grid);
	GrievanceData gd = new GrievanceData();
	gd.getSetGrievanceData(grida);
	String prevagentstatus = gd.get_agent_status();
	String prevuserstatus = gd.get_user_status();
	String action = request.getParameter("whataction");


	String useremail = sesh.getAttribute("useremail").toString();
	
	GrievanceHandle gh = new GrievanceHandle();
	gh.addComment(comment, useremail, userrole, grida, action, prevagentstatus, prevuserstatus);
	
	String redirectpage = "customergrievancedetail?gr_id="+grid;
		response.sendRedirect(redirectpage);
	} else {
		response.sendRedirect("login");
	}
	
	}
}






