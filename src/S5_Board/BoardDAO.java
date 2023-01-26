package S5_Board;

import java.util.ArrayList;

public class BoardDAO {

	private ArrayList<Board> boardList;
	private int count = 0; // ��ü �Խñ� ��
	private int pageSize = 5; // �� �������� ������ �Խñ� ��
	private int curPageNum = 1; // ���� ������ ��ȣ
	private int pageCount = 1; // ��ü ������ ����
	private int startRow = 0; // ���� �������� �Խñ� ���� ��ȣ
	private int endRow = 0; // ���� �������� �Խñ� ������ ��ȣ

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
			System.out.println("[!ù ������ �Դϴ�]");
			return;
		}
		curPageNum--;
	}

	public void nextCurPageNum() {
		if (curPageNum == pageCount) {
			System.out.println("[!������ ������ �Դϴ�]");
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
		Board board = new Board("a", "������� �ʹ� ��ο�", "���� �̺�Ʈ�� ���ּ���");
		boardList.add(board);
		board = new Board("b", "���ڰ� �ʹ� ��ο�", "���� �̺�Ʈ�� ���ּ���");
		boardList.add(board);
		count += 2;
	}
}
