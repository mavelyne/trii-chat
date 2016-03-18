package triichat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GroupListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println("{\"groups\": [{\"id\": 10, \"name\": \"GOne\"}, {\"id\": 20, \"name\": \"GTwo\"}, {\"id\": 30, \"name\": \"GThree\"}]}");
	}
}
