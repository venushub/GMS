package basePackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newPackage.GrievanceId;;

@WebServlet("/createnewgrievance")
public class CreateNewGrievanceServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GrievanceId gid = new GrievanceId();
		int gr_id = gid.getGrievanceId();
		gr_id = gr_id + 1;
		int userid = 3101;
		String category = request.getParameter("category");
		String grievancenote = request.getParameter("grievancenote");
		LocalDate localDate = LocalDate.now();
		/*System.out.println(category);
		System.out.println(grievancenote);
		*/
		
		try {
	           Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	           System.out.println("Class not found " + e);
	    }
		
		try {
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GMS","postgres","nsdl@123");
		Statement stmt=con.createStatement();
		String query = "INSERT INTO Grievance.grievance_main(gr_id,user_id,gr_type,gr_msg,gr_time_stamp) VALUES("+ gr_id + "," + userid + "," +"'"+ category+"'"+"," +"'"+ grievancenote +"'"+","+"'"+ localDate+"'"+")";
		stmt.executeQuery(query);
	    con.close();
		} catch (SQLException e) {
	        System.out.println(e);
		}
		/*HttpSession session = request.getSession(false);
		session.setAttribute("username", "venu");*/
		request.setAttribute("username", "venu");
		request.setAttribute("userid", "1234");
		request.getRequestDispatcher("/WEB-INF/newgrievance.jsp").forward(request, response);
	}
}