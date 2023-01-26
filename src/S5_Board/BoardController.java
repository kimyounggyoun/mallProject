package S5_Board;

import java.util.Scanner;

import S0_MALL.MallController;
import S1_Member.MemberController;
import S_MyUtil.Util;

public class BoardController {
	private BoardController() {
	}

	static private BoardController instance = new BoardController();

	static public BoardController getInstance() {
		return instance;
	}

	private BoardDAO boardDAO;
	private BoardController boardController;
	private MallController mallController;
	private Scanner scan;

	public void init(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
		scan = Util.scan;
		boardController = BoardController.getInstance();
		mallController = MallController.getInstance();
	}

	public void menuBoard() {
		while (true) {
			System.out.printf("�ѰԽñۼ� : %d / ������ %d/%d \n", boardDAO.getCount(), boardDAO.getCurPageNum(),
					boardDAO.getPageCount());
			boardDAO.printPage();
			System.out.println("[1.����������] [2.����������] [3.�Խñ��ۼ�] [4.��������] [0.�ڷΰ���]");
			int sel = Util.scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				boardDAO.backCurPageNum();
			} else if (sel == 2) {
				boardDAO.nextCurPageNum();
			} else if (sel == 3) {
				System.out.print("�Խñ��� �ۼ��մϴ�.");
				System.out.print("���� : ");
				String title = Util.scan.next();
				Util.scan.nextLine();
				System.out.print("���� : ");
				String maintext = Util.scan.next();
				Util.scan.nextLine();
				Board baord = new Board(mallController.getMemberLoginID(), title, maintext);
				boardDAO.newText(baord);
				System.out.println("�ۼ��� �Ϸ� �Ǿ����ϴ�.");

			} else if (sel == 4) {
				TextMain();
			} else {

			}
		}
	}

	public void TextMain() {
		System.out.println("Ȯ���� �Խù� ��ȣ�� �Է����ּ���");
		int idx = Util.scan.nextInt();
		boardDAO.printTextMain(idx - 1);
		System.out.println("[1.�Խñۻ���][0.�ڷΰ���]");
		int sel = Util.scan.nextInt();
		if (sel == 0) {
			return;
		} else if (sel == 1) {
			if (mallController.getMemberLoginID().equals(boardDAO.getBoardList().get(idx - 1).getMemberID())) {
				boardDAO.deleteText(idx - 1);
				return;
			} else {
				System.out.println("������ �Խñ۸� ���� �����մϴ�.");
				return;
			}
		}

	}

}
