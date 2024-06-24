package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import book.JDBConnection;
import book.Book;

public class BookDAO {
	public int deleteMember(int no) {
	int result = 0;
	//db 연결
	 JDBConnection jdbc = new JDBConnection();
	 //sql문 만들기
	 String sql = "delete member where no=?";
	 
	 //preparedStatement 객체 생성
	 try {
		 jdbc.pstmt = jdbc.conn.prepareStatement(sql);
		 jdbc.pstmt.executeUpdate();
		 System.out.println(result+"행이 삭제되었습니다.");
		 
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		jdbc.close();
	}return result;
	
	
}
public int updateBook(Book Book) {
	
JDBConnection jdbc = new JDBConnection();
String sql = new StringBuilder()
.append("update book")
.append("set Title=?,author=?,publisher=?,price=?")
.append("where bookId=?")
.toString();
int result = 0;

try {
//ps객체,매개변수 set
jdbc.pstmt =jdbc.conn.prepareStatement(sql);
jdbc.pstmt.setString(1, Book.getTitle());
jdbc.pstmt.setString(2, Book.getAuthor());
jdbc.pstmt.setString(3, Book.getPublisher());
jdbc.pstmt.setInt(4, Book.getPrice());
jdbc.pstmt.setString(5, Book.getBookId());



result = jdbc.pstmt.executeUpdate();
System.out.println(result+"행이 수정되었습니다");
}catch(SQLException e) {
e.printStackTrace();
}finally {
jdbc.close();
}
return result;
}

}