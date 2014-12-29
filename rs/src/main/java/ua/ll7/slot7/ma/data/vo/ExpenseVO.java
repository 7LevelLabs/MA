package ua.ll7.slot7.ma.data.vo;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:39
 */
public class ExpenseVO {

	private long id;

	private long categoryForTheUserId;

	private String expenseAmountCurrencySign;

	private float expenseAmountValue;

	private long registered;

	private String actionDateSign;

	private String description;

	public ExpenseVO() {
	}

	public ExpenseVO(long id, long categoryForTheUserId, String expenseAmountCurrencySign, float expenseAmountValue, long registered, String actionDateSign, String description) {
		this.id = id;
		this.categoryForTheUserId = categoryForTheUserId;
		this.expenseAmountCurrencySign = expenseAmountCurrencySign;
		this.expenseAmountValue = expenseAmountValue;
		this.registered = registered;
		this.actionDateSign = actionDateSign;
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ExpenseVO{");
		sb.append("id=").append(id);
		sb.append(", categoryForTheUserId=").append(categoryForTheUserId);
		sb.append(", expenseAmountCurrencySign='").append(expenseAmountCurrencySign).append('\'');
		sb.append(", expenseAmountValue=").append(expenseAmountValue);
		sb.append(", registered=").append(registered);
		sb.append(", actionDateSign='").append(actionDateSign).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryForTheUserId() {
		return categoryForTheUserId;
	}

	public void setCategoryForTheUserId(long categoryForTheUserId) {
		this.categoryForTheUserId = categoryForTheUserId;
	}

	public String getExpenseAmountCurrencySign() {
		return expenseAmountCurrencySign;
	}

	public void setExpenseAmountCurrencySign(String expenseAmountCurrencySign) {
		this.expenseAmountCurrencySign = expenseAmountCurrencySign;
	}

	public float getExpenseAmountValue() {
		return expenseAmountValue;
	}

	public void setExpenseAmountValue(float expenseAmountValue) {
		this.expenseAmountValue = expenseAmountValue;
	}

	public long getRegistered() {
		return registered;
	}

	public void setRegistered(long registered) {
		this.registered = registered;
	}

	public String getActionDateSign() {
		return actionDateSign;
	}

	public void setActionDateSign(String actionDateSign) {
		this.actionDateSign = actionDateSign;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
