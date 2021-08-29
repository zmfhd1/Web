package first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://localhost:9090/servlettest/first.FristServlet.class
//패키지명.서블릿클래스명.class(실제파일명) --별명 / FirstServlet

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first") //웹에서의 별명 설정

public class FirstServlet extends HttpServlet {
	
//	서버 종료시, 서블릿 코드 수정 - 재컴파일 시, 이전 서블릿 객체 삭제시
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
	
//	서버시작 최초 한번 실행
//	저장-자동 컴파일- (이전 서블릿 객체 사라짐 - destroy 실행) - 
	@Override
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
//	호출(요청)할 때마다 여러번 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");
	}

}
