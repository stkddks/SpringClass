package org.zerock.domain;

public class UserVO {
	private int userNo;
	
	private String userId;
	
	private String userPw;
	
	private String userNickname;
	
	private String userEmail;
	
	private String userStatus;
	private String userCase;
	private String userRegdate;	
	
	private boolean userIdExist;
	
	public UserVO() {
		this.userIdExist = false;
	}

	public UserVO(int userNo, String userId, String userPw, String userNickname, String userEmail, String userStatus,
			String userCase, String userRegdate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userStatus = userStatus;
		this.userCase = userCase;
		this.userRegdate = userRegdate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserCase() {
		return userCase;
	}

	public void setUserCase(String userCase) {
		this.userCase = userCase;
	}

	public String getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}

	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}

}
