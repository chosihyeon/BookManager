package temp;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.ListCartDAO;
import cart.SHCartService;

public class CartTest {

	public static void main(String[] args) {
		CartService Service = new SHCartService(new ListCartDAO());
		List<CartItem>itemList;
	}

}
