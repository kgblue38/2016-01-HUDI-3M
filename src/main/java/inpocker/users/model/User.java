package inpocker.users.model;

public class User {
	private int pid;
	private String userId;
	private String userPassword;
	private String userEmail;
	
	public User(int pid, String userId, String userPassword, String userEmail) {
		this.pid = pid;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}

	public User(String userId, String userPassword, String email) {
		this(0, userId, userPassword, email);
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
}
