package cart;

public class CartItem {
	private int no;
	private int bookId;
	private int quantity;
	
	public CartItem (int bookId, int quantity) {
		this.bookId = bookId;
		this.quantity = quantity;
	}
	public CartItem (int id, int bookId, int quantity) {
		this.bookId = id; 
		this.bookId = bookId;
		this.quantity = quantity;
		
	
}
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cartitem [no=" + no + ", bookId=" + bookId + ", quantity=" + quantity + "]";
}
}