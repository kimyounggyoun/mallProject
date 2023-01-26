package S5_Board;

import java.util.ArrayList;

public class BoardDAO {

	private ArrayList<Board> boardList;
	private int count = 0; // 전체 게시글 수
	private int pageSize = 5; // 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1; // 현재 페이지 번호
	private int pageCount = 1; // 전체 페이지 개수
	private int startRow = 0; // 현재 페이지의 게시글 시작 번호
	private int endRow = 0; // 현재 페이지의 게시글 마지막 번호

	public BoardDAO() {
		boardList = new ArrayList<Board>();
		setSampleData();
	}

	public ArrayList<Board> getBoardList() {
		return boardList;
	}

	public int getCount() {
		return count;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void backCurPageNum() {
		if (curPageNum == 1) {
			System.out.println("[!첫 페이지 입니다]");
			return;
		}
		curPageNum--;
	}

	public void nextCurPageNum() {
		if (curPageNum == pageCount) {
			System.out.println("[!마지막 페이지 입니다]");
			return;
		}
		curPageNum++;
	}

	public void newText(Board board) {
		boardList.add(board);
		count++;
	}

	public void deleteText(int idx) {
		boardList.remove(idx);
		count--;
	}

	public void printPage() {
		pageCount = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;

		startRow = (curPageNum - 1) * pageSize;
		endRow = startRow + pageSize > count ? count : startRow + pageSize;
		endRow--;

		for (int i = startRow; i <= endRow; i++) {
			System.out.printf("(%d) %s \n", i + 1, boardList.get(i).getTitle());
		}
	}

	public void printTextMain(int idx) {
		System.out.println(boardList.get(idx).toString());
	}

	public void setSampleData() {
		Board board = new Board("a", "음료수가 너무 비싸요", "할인 이벤트좀 해주세요");
		boardList.add(board);
		board = new Board("b", "과자가 너무 비싸요", "할인 이벤트좀 해주세요");
		boardList.add(board);
		count += 2;
	}
}
