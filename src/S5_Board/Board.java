package S5_Board;

public class Board {
	private String memberID;
	private String title;
	private String mainText;

	public Board(String memberID, String title, String mainText) {
		super();
		this.memberID = memberID;
		this.title = title;
		this.mainText = mainText;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainText() {
		return mainText;
	}

	public void setMainText(String mainText) {
		this.mainText = mainText;
	}

	@Override
	public String toString() {
		return "�ۼ��� : " + memberID + "\n������ : " + title + "\n�� �� :" + mainText;
	}

}
