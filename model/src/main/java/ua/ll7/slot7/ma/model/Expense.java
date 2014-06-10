package ua.ll7.slot7.ma.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
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
public class Expense implements Serializable {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	public Category getCategory() {
		return category;
	}

	@Columns(columns = {@Column(name = "currency"), @Column(name = "amount")})
	@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
	public Money getExpenseAmount() {
		return expenseAmount;
	}

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegistered() {
		return registered;
	}

	@Column
	@Temporal(TemporalType.DATE)
	public Date getActionDate() {
		return actionDate;
	}

	@Version
	public long getVersion() {
		return version;
	}

	/**
	 * Constructor
	 */
	public Expense() {
		setRegistered(new Date());
		setActionDate(new Date());
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setExpenseAmount(Money expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	@PrePersist
	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	private long id;

	@NotNull(message = "Expense category must be not null")
	private Category category;

	@NotNull(message = "Expense amount must be not null")
	private Money expenseAmount;

	@NotNull(message = "Expense date of register must be not null")
	private Date registered;

	@NotNull(message = "Expense action date must be not null")
	private Date actionDate;

	private long version;

}
