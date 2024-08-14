package exercise.bean;

public class CartDataBean {
	private int no;			//일련번호
	private String userId;	//사용자아이디
	private String exCode;	//운동코드
	private ExerciseDataBean exercise;
	
	public CartDataBean() {
		super();
	}

	public CartDataBean(int no, String userId, String exCode) {
		super();
		this.no = no;
		this.userId = userId;
		this.exCode = exCode;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}
	
	public void setExercise(ExerciseDataBean exercise) {
        this.exercise = exercise;
    }

    public ExerciseDataBean getExercise() {
        return this.exercise;
    }

	@Override
	public String toString() {
		return "CartVO [userId=" + userId + ", exCode=" + exCode + "]";
	}
	
}
