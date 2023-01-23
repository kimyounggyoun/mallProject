package S4_Cart;

import java.util.ArrayList;
import java.util.Scanner;

import S0_MALL.MallController;
import S2_Item.Item;
import S_MyUtil.Util;

public class CartController {
	private CartController() {
	}

	static private CartController instance = new CartController();

	static public CartController getInstance() {
		return instance;
	}

	private CartDAO cartDAO;
	private Scanner scan;
	private MallController mallController;

	public void init(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
		scan = Util.scan;
		mallController = MallController.getInstance();
	}

	public void insertCart(Item item) {
		Cart cart = new Cart();
		cart.setNumber(cartDAO.getCartNumber());
		cart.setMemberID(mallController.getMemberLoginID());
		cart.setItemName(item.getItemName());
		cart.setItemPrice(item.getPrice());
		cartDAO.insertCart(cart); // dao insert
	}

	public void buyCart() {
		printOneCartList();
		int sum = 0;
		ArrayList<Cart> temp = cartDAO.getOneCartList(mallController.getMemberLoginID());
		for (int i = 0; i < temp.size(); i++) {
			sum += temp.get(i).getItemPrice();
		}
		System.out.printf("총 금액 : %d 원 구매 하였습니다.\n", sum);
		cartDAO.buyCart(mallController.getMemberLoginID());
	}

	public void deleteCart() {
		printOneCartList();
		System.out.print("삭제할 리스트 번호 : ");
		int num = scan.nextInt();
		ArrayList<Cart> temp = cartDAO.getOneCartList(mallController.getMemberLoginID());
		int idx = 0;
		for (Cart cart : temp) {
			if (cart.getNumber() == num) {
				cartDAO.deleteCart(idx);
				break;
			}
			idx++;
		}
	}

	public void menuCart() {
		while (true) {
			System.out.println("===[장바구니관리]===");
			System.out.println("1)장바구니출력 2)구입 3)삭제 0)뒤로가기");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				printOneCartList();
			} else if (sel == 2) {
				buyCart();

			} else if (sel == 3) {
				deleteCart();
			}
		}
	}

	public void printOneCartList() {
		ArrayList<Cart> oneCartList = cartDAO.getOneCartList(mallController.getMemberLoginID());
		cartDAO.printOneCartList(oneCartList);
	}

	public void printAllCartList() {
		cartDAO.printAllCartList();
	}
}
