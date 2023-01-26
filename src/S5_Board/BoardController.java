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
			System.out.printf("총게시글수 : %d / 페이지 %d/%d \n", boardDAO.getCount(), boardDAO.getCurPageNum(),
					boardDAO.getPageCount());
			boardDAO.printPage();
			System.out.println("[1.이전페이지] [2.다음페이지] [3.게시글작성] [4.본문보기] [0.뒤로가기]");
			int sel = Util.scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				boardDAO.backCurPageNum();
			} else if (sel == 2) {
				boardDAO.nextCurPageNum();
			} else if (sel == 3) {
				System.out.print("게시글을 작성합니다.");
				System.out.print("제목 : ");
				String title = Util.scan.next();
				Util.scan.nextLine();
				System.out.print("내용 : ");
				String maintext = Util.scan.next();
				Util.scan.nextLine();
				Board baord = new Board(mallController.getMemberLoginID(), title, maintext);
				boardDAO.newText(baord);
				System.out.println("작성이 완료 되었습니다.");

			} else if (sel == 4) {
				TextMain();
			} else {

			}
		}
	}

	public void TextMain() {
		System.out.println("확인할 게시물 번호를 입력해주세요");
		int idx = Util.scan.nextInt();
		boardDAO.printTextMain(idx - 1);
		System.out.println("[1.게시글삭제][0.뒤로가기]");
		int sel = Util.scan.nextInt();
		if (sel == 0) {
			return;
		} else if (sel == 1) {
			if (mallController.getMemberLoginID().equals(boardDAO.getBoardList().get(idx - 1).getMemberID())) {
				boardDAO.deleteText(idx - 1);
				return;
			} else {
				System.out.println("본인의 게시글만 삭제 가능합니다.");
				return;
			}
		}

	}

}
