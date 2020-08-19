package web_study_03;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ResearchServlet() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prcessRequest(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prcessRequest(request, response);		
	}

	private void prcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String [] seasons = request.getParameterValues("season");
		
		if(seasons == null) {
			seasons = new String[] {"좋아하는 계절 없음"};
		}		
		if(gender.equals("male")){
			gender = "남자";			 
		}else {
			gender = "여자";
		}
		
		for(String season : seasons) {
			int s = Integer.parseInt(season);
		String seasonRes="";{
			switch(s) {
			case 1 : seasonRes += "봄";break;
			case 2 : seasonRes += "여름";break;
			case 3 : seasonRes += "가을";break;
			case 4 : seasonRes += "겨울";break;
			}
		}
		
	}
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("season", seasonRes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("researchResult.jsp?name="+name+"&gender"+gender+"&season="+seasonRes);
		
	}
}
