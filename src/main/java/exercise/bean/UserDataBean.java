package exercise.bean;

public class UserDataBean {
	private int no;
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String birthday;
	private String postcode;
	private String addr;
	private String addr1;
	private String addr2;
	private String kakao;
	private String mailing;
	private String sns;
	private String security;
	private int isInstructor;
	private String insExercise;
	
	private String totalAddr;
	private String isInstructorNm;

	public UserDataBean() {
		super();
	}

	public UserDataBean(int no, String userId, String userPassword, String userName, String userEmail, String userPhone,
			String birthday, String postcode, String addr, String addr1, String addr2, String kakao, String mailing,
			String sns, String security, int isInstructor, String insExercise) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.birthday = birthday;
		this.postcode = postcode;
		this.addr = addr;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.kakao = kakao;
		this.mailing = mailing;
		this.sns = sns;
		this.security = security;
		this.isInstructor = isInstructor;
		this.insExercise = insExercise;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getKakao() {
		return kakao;
	}

	public void setKakao(String kakao) {
		this.kakao = kakao;
	}

	public String getMailing() {
		return mailing;
	}

	public void setMailing(String mailing) {
		this.mailing = mailing;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public int getIsInstructor() {
		return isInstructor;
	}

	public void setIsInstructor(int isInstructor) {
		this.isInstructor = isInstructor;
	}

	public String getInsExercise() {
		return insExercise;
	}

	public void setInsExercise(String insExercise) {
		this.insExercise = insExercise;
	}
	
	public String getTotalAddr() {
		return totalAddr;
	}

	public void setTotalAddr(String totalAddr) {
		this.totalAddr = totalAddr;
	}	

	public String getIsInstructorNm() {
		return isInstructorNm;
	}

	public void setIsInstructorNm(String isInstructorNm) {
		this.isInstructorNm = isInstructorNm;
	}

	@Override
	public String toString() {
		return "UserDataBean [no=" + no + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", birthday=" + birthday
				+ ", postcode=" + postcode + ", addr=" + addr + ", addr1=" + addr1 + ", addr2=" + addr2 + ", kakao="
				+ kakao + ", mailing=" + mailing + ", sns=" + sns + ", security=" + security + ", isInstructor="
				+ isInstructor + ", insExercise=" + insExercise + "]";
	}

}
