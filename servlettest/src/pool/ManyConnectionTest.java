package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manyconnection")
public class ManyConnectionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		for(int i = 1; i<=1000; i++) {
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println(i + " 번째 연결성공");		
			con.close();
			System.out.println("연결해제성공");
		}
		
		}catch(SQLException e) {/**/}
		catch(ClassNotFoundException e) {/**/}
		//응답
	}

}
