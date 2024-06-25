package test;

import java.util.List;

import book.Book;
import book.BookDAO;
import book.BookService;

public class BookManagerTest {

	public static void main(String[] args) {
		BookService service = new BookService(new BookDAO());

		List<Book> bookList = service.listAll();

		for (Book book : bookList) {
			System.out.println(book.toString());
		}
		
		Book book = service.read(2);
		System.out.println(book.toString());
		
		/*book = new Book("BC202","그냥","귀찮","집출판사",2000);
		if(service.regist(book)) {
			System.out.println("책 추가 성공");
		} else {
			System.out.println("책 추가 실패");
		}*/
		service.remove(3);
		
		
	}

}
