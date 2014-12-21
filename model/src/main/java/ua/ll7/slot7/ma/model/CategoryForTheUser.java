package ua.ll7.slot7.ma.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 13:25
 */

/**
 * Consumption category for the User
 */
@Entity
@Table(indexes = {
	@Index(
		columnList = "user_id")
}
)
public class CategoryForTheUser implements Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	public User getUser() {
		return user;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	@OneToMany(fetch = FetchType.LAZY,
		mappedBy = "categoryForTheUser",
		cascade = {CascadeType.ALL})
	public List<Expense> getExpenses() {
		return expenses;
	}

	@Version
	public long getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CategoryForTheUser categoryForTheUser = (CategoryForTheUser) o;

		if (!name.equals(categoryForTheUser.name)) return false;
		if (!user.equals(categoryForTheUser.user)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = user.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CategoryForTheUser{");
		sb.append("id=").append(id);
		sb.append(", user=").append(user.getId());
		sb.append(", name='").append(name).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", expenses=").append(expenses.size());
		sb.append(", version=").append(version);
		sb.append('}');
		return sb.toString();
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	private long id;

	@NotNull(message = "User for this CategoryForTheUser must be not null")
	private User user;

	@NotBlank(message = "CategoryForTheUser Name must be not blank")
	private String name;

	@NotBlank(message = "CategoryForTheUser Description must be not blank")
	private String description;

	private List<Expense> expenses = new LinkedList<Expense>();

	private long version;
}
