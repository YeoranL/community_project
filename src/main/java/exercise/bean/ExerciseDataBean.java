package exercise.bean;

public class ExerciseDataBean {
	private int no; // 일련번호
	private String exCode; // 운동코드
	private String exName; // 운동제목명
	private String exLocation; // 위치
	private String exDate; // 날짜
	private int exMembercount; // 인원수
	private String userId; // 강사아이디
	private String exPrice; // 가격
	
	private String insName;//강사명

	public ExerciseDataBean() {
		super();
	}

	public ExerciseDataBean(int no, String exCode, String exName, String exLocation, String exDate, int exMembercount,
			String userId, String exPrice) {
		super();
		this.no = no;
		this.exCode = exCode;
		this.exName = exName;
		this.exLocation = exLocation;
		this.exDate = exDate;
		this.exMembercount = exMembercount;
		this.userId = userId;
		this.exPrice = exPrice;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getExLocation() {
		return exLocation;
	}

	public void setExLocation(String exLocation) {
		this.exLocation = exLocation;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

	public int getExMembercount() {
		return exMembercount;
	}

	public void setExMembercount(int exMembercount) {
		this.exMembercount = exMembercount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getExPrice() {
		return exPrice;
	}

	public void setExPrice(String exPrice) {
		this.exPrice = exPrice;
	}	
	
	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	@Override
	public String toString() {
		return "ExerciseVO [exCode=" + exCode + ", exName=" + exName + ", exLocation=" + exLocation + ", exDate="
				+ exDate + ", exMembercount=" + exMembercount + ", userId=" + userId + ", exPrice=" + exPrice + "]";
	}

}
