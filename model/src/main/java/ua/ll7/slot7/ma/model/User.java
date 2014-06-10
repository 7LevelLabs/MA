package ua.ll7.slot7.ma.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 13:41
 */

/**
 * System user. Key field : {@link #email}
 */
@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public long getId() {
		return id;
	}

	@Column(nullable = false,unique = true)
	@Index(name = "email")
	public String getEmail() {
		return email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(nullable = false)
	@Index(name = "nick")
	public String getNick() {
		return nick;
	}

	@Column(nullable = false)
	@Index(name = "name")
	public String getName() {
		return name;
	}

	@Column(nullable = false)
	@Index(name = "apiCode")
	public String getApiCode() {
		return apiCode;
	}

	@OneToMany(fetch = FetchType.LAZY,
		mappedBy = "user",
		cascade = {CascadeType.ALL})
	public List<Category> getCategories() {
		return categories;
	}

	@Version
	public long getVersion() {
		return version;
	}

	/**
	 * Constructor
	 */
	public User() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!email.equals(user.email)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("id=").append(id);
		sb.append(", email='").append(email).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", nick='").append(nick).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", apiCode='").append(apiCode).append('\'');
		sb.append(", categories=").append(categories.size());
		sb.append(", version=").append(version);
		sb.append('}');
		return sb.toString();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	private long id;

	@NotBlank(message = "User's EMail must be not blank")
	private String email;

	@NotBlank(message = "User's Password must be not blank")
	private String password;

	@NotBlank(message = "User's Nick must be not blank")
	private String nick;

	@NotBlank(message = "User's Name must be not blank")
	private String name;

	@NotBlank(message = "User's API code must be not blank")
	private String apiCode;

	private List<Category> categories = new LinkedList<Category>();

	private long version;

}
