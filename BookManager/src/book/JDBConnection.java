package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class JDBConnection {
		public Connection conn;
		public PreparedStatement pstmt;
		public ResultSet rs;


	  public Connection JDBConnetion() throws SQLException {
	      
	      final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
	      final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	      final String userid = "c##java";
	      final String passwd = "1234";
	      //DB연결 객체 생성 반환
	      Connection conn = null;
	      
	      
	      try {
	         //JDBC 드라이버 로딩
	         Class.forName(jdbcDriverClassName);
	         
	         //Connection 객체 생성
	         conn = DriverManager.getConnection(url, userid, passwd);
	         System.out.println("오라클 DB 연결 성공");
	         
	         
	      }catch(ClassNotFoundException e) {
	         e.printStackTrace();
	      }
		return conn;
	      
	   }

public void close() {
	try {
		if(conn !=null) conn.close();
		if(pstmt != null)pstmt.close();
		if(rs != null)pstmt.close();
		}catch(SQLException e) {
		e.printStackTrace();	
		}
	}
}


