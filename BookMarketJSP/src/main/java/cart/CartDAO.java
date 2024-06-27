package cart;

import java.util.List;

public interface CartDAO {
	//c
	int insert(CartItem item);
	//R
	CartItem select(int id) ;
	CartItem selectByBookId(int bookId) ;
	List<CartItem> selectAll();
	//u
	int update(int id, int quantity); 
	//d
	int delete(int id);
		
	int deleteAll();	
}
