package basePackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newgrievance")
public class NewGrievanceServ extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false);
		session.setAttribute("username", "venu");*/
		request.setAttribute("username", "venu");
		request.setAttribute("userid", "1234");
		request.getRequestDispatcher("/WEB-INF/newgrievance.jsp").forward(request, response);
	}
}