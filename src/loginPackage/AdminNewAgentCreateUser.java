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


@WebServlet("/adminnewagentuserregister")
public class AdminHomeServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesh = request.getSession(false);
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
		
		
		String username = request.getParameter("name");
		String useremail = request.getParameter("email");
		
        
        try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
		int i = 1;
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("select gr_type, gr_msg, gr_time_stamp from Grievance.grievance_main");
		while(rs.next()){

			ArrayList<String> row = new ArrayList<String>();
			row.add(Integer.toString(i));
			row.add(rs.getString("gr_type"));
			row.add(rs.getString("gr_msg"));
			
			LocalDate localDate = rs.getObject("gr_time_stamp",LocalDate.class);//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = localDate.format(formatter);
			
			row.add(formattedString);
			i++;
			
			tableelems.add(row);
			
		}
	    con.close();
		} catch (SQLException e) {
	        System.out.println(e);
		}
      
		request.setAttribute("tableelems", tableelems);
		
		if(sesh.getAttribute("useremail") != null) {
		request.getRequestDispatcher("/WEB-INF/AdminHome.jsp").forward(request, response);
		}	else {
			response.sendRedirect("login");
		}
	}
}