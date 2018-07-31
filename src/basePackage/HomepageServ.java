package basePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomepageServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession sesh = request.getSession(false);
		
		if( sesh != null && sesh.getAttribute("useremail") != null && sesh.getAttribute("userrole").equals("customer")){

		String useremail = sesh.getAttribute("useremail").toString();
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
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select gr_id, gr_type, gr_msg, gr_time_stamp, status, status_weight from Grievance.grievance_main WHERE user_email="+"'"+useremail+"'");
		while(rs.next()){
			ArrayList<String> row = new ArrayList<String>();
			row.add(rs.getString("gr_id"));
			row.add(rs.getString("gr_type"));
			row.add(rs.getString("gr_msg"));
			LocalDate localDate = rs.getObject("gr_time_stamp",LocalDate.class);//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = localDate.format(formatter);
			
			row.add(formattedString);
			row.add(rs.getString("status"));
			row.add(rs.getString("status_weight"));
			tableelems.add(row);
		}
	    con.close();
		} catch (SQLException e) {
	        System.out.println(e);
		}
		
		/*Collections.sort(arg0);
		tableelems.sort();*/
		Collections.reverse(tableelems);
		request.setAttribute("tableelems", tableelems);
		
			request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
	}
}