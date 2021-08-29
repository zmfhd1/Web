package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/memberinsert")
public class MemberInsertServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		request.setCharacterEncoding("utf-8");
		
		//html 파라미터 다 읽어와라
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");
		String membername = request.getParameter("membername");
		String email = request.getParameter("email");
		
		MemberVO vo = new MemberVO(memberid, Integer.parseInt(password), membername, email);
		MemberDAO dao = new MemberDAO();
		int result = dao.insertMember(vo);

		System.out.println("클라이언트로부터" + memberid + "데이터를 전송받았습니다.");
		System.out.println("클라이언트로부터" + password + "데이터를 전송받았습니다.");
		System.out.println("클라이언트로부터" + membername + "데이터를 전송받았습니다.");
		System.out.println("클라이언트로부터" + email + "데이터를 전송받았습니다.");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if(result == 1) {
			o.println("<h3>정상 등록완료</h3>");
		}
		else {
			o.println("등록 실패");			
		}
		
	}

}
