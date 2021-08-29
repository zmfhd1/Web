package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	//요청	
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String user_password = request.getParameter("password");
		//jdbc (member1:1111 member2:2222)
		
		MemberDAO dao = new MemberDAO();
		String result = dao.getMember(id, user_password);
		
	//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
		
		//MemberListSERVLET . html태그 속성: '/' 서버 루트 : 
		request.setAttribute("role", "AdmIn"); //요청객체 내부 서블릿 추가 데이터 저장
		RequestDispatcher rd = request.getRequestDispatcher("/memberlist");
		rd.forward(request, response); //
		
		o.println("<h1>완료</h1>");
		
	}

}
