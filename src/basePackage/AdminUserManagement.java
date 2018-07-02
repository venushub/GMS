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


@WebServlet("/adminusermgmt")
public class AdminUserManagement extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        	request.getRequestDispatcher("/WEB-INF/AdminUserManagement.jsp").forward(request, response);
        	
        }
	}
