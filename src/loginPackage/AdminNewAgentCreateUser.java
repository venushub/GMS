package loginPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newPackage.LoginCheck;
import newPackage.UserId;


@WebServlet("/adminnewagentuserregister")
public class AdminNewAgentCreateUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserId uid = new UserId();
		int user_id = uid.getUserId();
		user_id = user_id + 1;
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "agent";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LoginCheck lc = new LoginCheck();
        String lcr = lc.checkUserinDatabase(email);
        if(lcr == "FALSE"){
        	uid.registerNewUser(user_id, name,email, password,role,timestamp);
        	response.sendRedirect("login");
        	//request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "email already exists in our database");
        	request.getRequestDispatcher("/WEB-INF/AdminUserCreateNewAgent.jsp").forward(request, response);
        }
	}
}