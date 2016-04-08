package inpoker.user.model;

import javax.validation.constraints.NotNull;

public class User {
	private int pid;
//	@Pattern(regexp = "/^[a-z]+[a-z0-9]{5,19}$/", message = "6~20 lettersstarting alphabet")
	@NotNull
	private String userId;

	// @Pattern(regexp =
	// "/^(?=.*[a-zA-Z])((?=.*[0-9])|(?=.*[a-zA-Z0-9_])).{6,20}$/", message =
	// "6~20 alphbets with number")
	@NotNull
	private String userPassword;

	// Qeustion .은 모든키 다 match되는 메타문자라서 js에서는 \.로 표현하는데 에러나서 \\.로 적었는데 맞나요?
	// hello@naver.com 여기서 .com 이 부분 매칭시키고 싶은데
	// @NotNull
//	 @Pattern(regexp = "/^[a-z0-9_+.-]+@([a-z0-9-]\\.)+[a-z0-9]{2,4}$/",
	// message = "Wrong email format")
	private String userEmail;
	
	public User() {
	}

	public User(int pid, String userId, String userPassword, String userEmail) {
		this.pid = pid;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}

	public User(String userId, String userPassword, String email) {
		this(0, userId, userPassword, email);
	}

	public void checkCorrectLogin(String userId, String userPassword) throws UserLoginFailedException {
		if (!(this.userId.equals(userId) && this.userPassword.equals(userPassword))) {
			throw new UserLoginFailedException();
		}
	}
	
	public boolean isMatchedUserId(String userId) {
		return this.userId.equals(userId);
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPid() {
		return pid;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + pid;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (pid != other.pid)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [pid=" + pid + ", userId=" + userId + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ "]";
	}
}
