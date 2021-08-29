package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id = request.getParameter("id"); //요청
		System.out.println("클라이언트로부터" + id + "데이터를 전송받았습니다.");
		
		String result = "";
		if(id.equals("jsp") || id.equals("servlet") || id.equals("spring") ) {
			result = "입력한 아이디" + id + "정상 로그인 되셨습니다.";
		}
		else {
			result = "입력한 아이디" + id + "로그인 할 수 없습니다.";
		}
		
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + result + "</h1>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
