package cart;

import java.util.List;

public class SHCartService implements CartService {
	CartDAO cartDao;
	public SHCartService(CartDAO cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean add(CartItem item) {
		
		if(item== null)return false;
		int result = 0;
		
		CartItem inItem = cartDao.selectByBookId(item.getBookId());
		if (inItem == null) {
			System.out.println("책 추가");
			result = cartDao.insert(item);
		} else {
			int quantity = item.getQuantity() + inItem.getQuantity();
			System.out.println("수량 변경 :" + quantity);
			result = cartDao.update(inItem.getNo(), inItem.getQuantity() + item.getQuantity());
		}
		
		return result == 1 ? true : false;
	}


	@Override
	public List<CartItem> listAll() {
		// TODO Auto-generated method stub
		return cartDao.selectAll();
	}

	@Override
	public boolean update(int id, int quantity) {
		int result = cartDao.update(id, quantity);
		
		return result == 1? true :false;
	}

	@Override
	public boolean remove(int no) {
		int result = cartDao.delete(no);
		return result==1? true:false;
	}

	@Override
	public boolean clear() {
		
		cartDao.deleteAll();
		return cartDao.selectAll().size() == 0 ? true : false;
	}

}
