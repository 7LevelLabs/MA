package ua.ll7.slot7.ma.data.vo;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:38
 */
public class UserVO {

	private long id;

	private String email;

	private String nick;

	private String name;

	private boolean active;

	public UserVO() {
	}

	public UserVO(long id, String email, String nick, String name, boolean active) {
		this.id = id;
		this.email = email;
		this.nick = nick;
		this.name = name;
		this.active = active;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserVO{");
		sb.append("id=").append(id);
		sb.append(", email='").append(email).append('\'');
		sb.append(", nick='").append(nick).append('\'');
		sb.append(", name='").append(name).append('\'');
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
