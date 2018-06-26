package basePackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createnewgrievance")
public class CreateNewGrievanceServ extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String grievancenote = request.getParameter("grievancenote");
		System.out.println(category);
		System.out.println(grievancenote);
		
		
		/*HttpSession session = request.getSession(false);
		session.setAttribute("username", "venu");*/
		request.setAttribute("username", "venu");
		request.setAttribute("userid", "1234");
		request.getRequestDispatcher("/WEB-INF/newgrievance.jsp").forward(request, response);
	}
}