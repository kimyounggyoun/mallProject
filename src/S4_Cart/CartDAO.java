package S4_Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartDAO {

	private ArrayList<Cart> cartList;
	private int cartNumber;

	public CartDAO() {
		cartList = new ArrayList<Cart>();
		cartNumber = 1000;

		int dd = 0;
	}

	public int getCartNumber() {
		cartNumber += 1;
		return cartNumber;
	}

	public void insertCart(Cart cart) {
		cartList.add(cart);
	}

	public void buyCart(String memberID) {
		for (int i = cartList.size() - 1; i >= 0; i--) {
			if (cartList.get(i).getMemberID().equals(memberID)) {
//				boolean buy = true;
//				((Cart) cartList.get(idx)).setBuy(buy); // 질문할것, boolean 변경
				cartList.remove(i);
			}

		}
	}

	public void deleteCart(int idxNum) {
		cartList.remove(idxNum);
	}

	public ArrayList<Cart> getOneCartList(String memberLoginID) { // 동일 id로 리스트 만들어서 출력
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();

		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMemberID().equals(memberLoginID) /* && cartList.get(i).isBuy() */) {
				oneCartList.add(cartList.get(i));
			}
		}
		return oneCartList;
	}

	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			System.out.println(i + 1 + ")" + oneCartList.get(i));
		}
	}

	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println(i + 1 + ")" + cartList.get(i));
		}
	}

}
