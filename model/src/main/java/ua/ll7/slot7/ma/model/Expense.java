package ua.ll7.slot7.ma.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Alex Velichko
 *         09.06.14 : 13:36
 */

/**
 * Expenses. Action date ({@link #actionDate}) can be voluntary.
 */
@Entity
@Table(indexes = {
	@Index(
		columnList = "categoryfortheuser_id")
}
)
public class Expense implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Expense categoryForTheUser must be not null")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private CategoryForTheUser categoryForTheUser;

	@NotNull(message = "Expense amount must be not null")
	@Columns(columns = {@Column(name = "currency"), @Column(name = "amount")})
	@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
	private Money expenseAmount;

	@NotNull(message = "Expense date of register must be not null")
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date registered = new Date();

	@NotNull(message = "Expense action date must be not null")
	@Column
	@Temporal(TemporalType.DATE)
	private Date actionDate = new Date();

	@Column
	private String description;

	@Version
	private long version;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Expense{");
		sb.append("id=").append(id);
		sb.append(", categoryForTheUser.id=").append(categoryForTheUser.getId());
		sb.append(", expenseAmount=").append(expenseAmount);
		sb.append(", registered=").append(registered);
		sb.append(", actionDate=").append(actionDate);
		sb.append(", description='").append(description).append('\'');
		sb.append(", version=").append(version);
		sb.append('}');
		return sb.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryForTheUser getCategoryForTheUser() {
		return categoryForTheUser;
	}

	public void setCategoryForTheUser(CategoryForTheUser categoryForTheUser) {
		this.categoryForTheUser = categoryForTheUser;
	}

	public Money getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(Money expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
