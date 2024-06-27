package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;

public class BookDAO {

	public int deletebook(int no) {
		int result = 0;
		// db 연결
		JDBConnection jdbc = new JDBConnection();
		// sql문 만들기
		String sql = "delete member where bookId=?";

		// preparedStatement 객체 생성
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);
			jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;

	}

	public int updateBook(Book Book) {

		JDBConnection jdbc = new JDBConnection();
		String sql = new StringBuilder().append("update book").append("set Title=?,author=?,publisher=?,price=?")
				.append("where bookId=?").toString();
		int result = 0;

		try {
//ps객체,매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, Book.getTitle());
			jdbc.pstmt.setString(2, Book.getAuthor());
			jdbc.pstmt.setString(3, Book.getPublisher());
			jdbc.pstmt.setInt(4, Book.getPrice());
			jdbc.pstmt.setString(5, Book.getBookId());

			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return result;
	}

	public int insertBook(Book book) {

		int result = 0;
		JDBConnection jdbc = new JDBConnection();

		String sql = "INSERT INTO BOOK(NO,BOOKID,TITLE,AUTHOR,PUBLISHER,PRICE,REGDATE)"
				+ "VALUES(book_seq.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setString(1, book.getBookId());
			jdbc.pstmt.setString(2, book.getTitle());
			jdbc.pstmt.setString(3, book.getAuthor());
			jdbc.pstmt.setString(4, book.getPublisher());
			jdbc.pstmt.setInt(5, book.getPrice());

			result = jdbc.pstmt.executeUpdate();

			if(result > 0) {
				System.out.println(result + "행이 추가되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.close();

		return result;
	}

	public Book selectbook(int no) {

		JDBConnection jdbc = new JDBConnection();
		Book book = null;
		String sql = "SELECT * FROM BOOK WHERE NO = ?";

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setInt(1, no);

			jdbc.rs = jdbc.pstmt.executeQuery();

			if (jdbc.rs.next()) {
				book = new Book(jdbc.rs.getInt("NO"), jdbc.rs.getString("BOOKID"), jdbc.rs.getString("TITLE"),
						jdbc.rs.getString("AUTHOR"), jdbc.rs.getString("PUBLISHER"), jdbc.rs.getInt("PRICE"),
						jdbc.rs.getDate("REGDATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.close();
		return book;
	}

	public List<Book> selectBookAll() {
		List<Book> bookList = new ArrayList<>();
		JDBConnection jdbc = new JDBConnection();

		String sql = "SELECT * FROM BOOK";

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.rs = jdbc.pstmt.executeQuery();

			while (jdbc.rs.next()) {
				bookList.add(new Book(jdbc.rs.getInt("NO"), 
						jdbc.rs.getString("BOOKID"),
						jdbc.rs.getString("TITLE"),
						jdbc.rs.getString("AUTHOR"),
						jdbc.rs.getString("PUBLISHER"), 
						jdbc.rs.getInt("PRICE"),
						jdbc.rs.getDate("REGDATE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.close();
		return bookList;
		
	
	}
	

}