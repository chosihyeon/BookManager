package book;

import java.util.List;

public class BookService {
	
	private BookDAO bookDao;

	public BookService(BookDAO bookdao) {
		this.bookDao=bookdao;
	}

	public boolean regist(Book book) {
	//왜 book이라고 해야되는거 아닌가? 
	int result = bookDao.insertBook(book);
	return result==1;
	}
	
	public Book read(int no) {
		Book book = bookDao.selectbook(no);
		return book;
	}
	
	public List<Book> listAll(){
		List<Book> bookList = bookDao.selectBookAll();
		return bookList;
	}
	public boolean edit(Book book) {
		return true;
	}
	
	public boolean remove(int no) {
		if(bookDao.selectbook(no)==null) {
		return false;	
		}
		int result= bookDao.deletebook(no);
		return result==1;
	}
	
	
	}