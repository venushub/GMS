package basePackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*HttpSession sesh = request.getSession();
    	if(sesh != null){
    		System.out.println("session is alive");
    	}
    	System.out.println(sesh.getAttribute("username").toString());*/
        request.getSession().invalidate();
    	response.sendRedirect("login");
/*		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
*/	}
}