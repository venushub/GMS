package basePackage;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newPackage.LoginCheck;
import newPackage.UserId;


@WebServlet("/newuserregister")
public class NewUserRegisterServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserId uid = new UserId();
		int user_id = uid.getUserId();
		user_id = user_id + 1;
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LoginCheck lc = new LoginCheck();
        String lcr = lc.checkUserinDatabase(email);
        if(lcr == "FALSE"){
        	uid.registerNewUser(user_id, name,email, password,timestamp);
        	response.sendRedirect("login");
        	//request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "email already exists in our database");
        	request.getRequestDispatcher("/WEB-INF/Registration.jsp").forward(request, response);
        }
	}
}