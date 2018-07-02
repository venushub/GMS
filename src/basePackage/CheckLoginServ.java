package basePackage;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newPackage.LoginCheck;
import newPackage.UserId;

@WebServlet("/checklogin")
public class CheckLoginServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserId uid = new UserId();
        LoginCheck lc = new LoginCheck();
        
        String lcr = lc.checkUserinDatabase(username,password);
        if(lcr == "TRUE"){
        	
        	String usernamefin = uid.getUserNameForSession(username);
        	HttpSession sesh = request.getSession();
        	sesh.setAttribute("username", usernamefin);
        	sesh.setAttribute("useremail", username);
        	String userrole = uid.getUserRole(username);
        	if(userrole.equalsIgnoreCase(new String("customer"))){
        		response.sendRedirect("home");
        	} else if (userrole.equalsIgnoreCase(new String("admin"))) {
        		response.sendRedirect("adminhome");
        	} else {
        		response.sendRedirect("agenthome");
        	}
        	//request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
        	request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
	}
}