package agentPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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


@WebServlet("/agenthome")
public class AgentHomeServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		session.setAttribute("username", username);
		session.setAttribute("useremail", useremail);*/
		ArrayList<ArrayList> tableelems = new ArrayList<ArrayList>();
       /* for(int i=1;i<10;i++){
		ArrayList<String> row = new ArrayList<String>();
		row.add("one");
		row.add("two");
		row.add("three");
		row.add("four");
		tableelems.add(row);
		}*/
        
        try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
	/*	int i = 1;*/
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select gr_id, user_email, gr_type, gr_msg, gr_time_stamp from Grievance.grievance_main");
		while(rs.next()){

			ArrayList<String> row = new ArrayList<String>();
	/*		row.add(Integer.toString(i));*/
			row.add(rs.getString("gr_id"));
			row.add(rs.getString("user_email"));
			row.add(rs.getString("gr_type"));
			row.add(rs.getString("gr_msg"));
			
			LocalDate localDate = rs.getObject("gr_time_stamp",LocalDate.class);//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = localDate.format(formatter);
			
			row.add(formattedString);
		/*	i++;*/
			
			tableelems.add(row);
			
		}
	    con.close();
		} catch (SQLException e) {
	        System.out.println(e);
		}
      
		Collections.reverse(tableelems);
		
		request.setAttribute("tableelems", tableelems);
		
		
		HttpSession sesh = request.getSession(false);
		if( sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("agent")){
			request.getRequestDispatcher("/WEB-INF/AgentHome.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}
}