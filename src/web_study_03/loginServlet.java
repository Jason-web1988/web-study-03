package web_study_03;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id="dlgustjr1024";
		String pwd="1234";
		String name="이현석";
		
		request.setCharacterEncoding("UTF-8");
		if(id.equals(request.getParameter("id"))&&pwd.equals(request.getParameter("pwd"))) {
			response.sendRedirect("loginResult.jsp?name="+URLEncoder.encode(name, "UTF-8"));
		}else {
			response.sendRedirect("loginForm.jsp");
		}
			
		
	}

}
