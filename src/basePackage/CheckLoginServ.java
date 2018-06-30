package basePackage;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import newPackage.LoginCheck;

@WebServlet("/checklogin")
public class CheckLoginServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginCheck lc = new LoginCheck();
        
        String lcr = lc.checkUserinDatabase(username,password);
        if(lcr == "TRUE"){
        	response.sendRedirect("home");
        	//request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
        	request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
	}
}