package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/manyconnectionpool")
public class ManyConnectionPool extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//1. context명 + 정보 저장 객체 생성
			Context initContext = new InitialContext();
			//2. server.xml 내용 읽어와.
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			//3. name = "jdbc/myoracle"설정만 찾아와 (ds = con pool)
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			//4. con 풀 꺼낸다
			for(int i = 1; i<=10000; i++) {
				Connection con = ds.getConnection();
//			Connection con = DriverManager.getConnection
//			("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
						
			System.out.println(i + " 번째 연결성공");		
			con.close();
//			System.out.println("연결해제성공");
		}
		
		}catch(SQLException e) {/**/}
		catch(NamingException e) {/**/}
		//응답
	}

}
