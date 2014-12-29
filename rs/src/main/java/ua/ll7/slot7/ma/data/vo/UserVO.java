package ua.ll7.slot7.ma.data.vo;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:38
 */
public class UserVO {

	private long id;

	private String email;

	private String password;

	private String nick;

	private String name;

	private String apiCode;

	private int role;

	private boolean active;

	public UserVO() {
	}

	public UserVO(long id, String email, String password, String nick, String name, String apiCode, int role, boolean active) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nick = nick;
		this.name = name;
		this.apiCode = apiCode;
		this.role = role;
		this.active = active;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserVO{");
		sb.append("id=").append(id);
		sb.append(", email='").append(email).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", nick='").append(nick).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", apiCode='").append(apiCode).append('\'');
		sb.append(", role=").append(role);
		sb.append(", active=").append(active);
		sb.append('}');
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
