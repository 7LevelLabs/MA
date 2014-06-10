package ua.ll7.slot7.ma.util.request;

import java.io.Serializable;

/**
 * @author Alex Velichko
 *         10.06.14 : 15:50
 */
public class ReqCategoryCreate implements Serializable {

	private long userId;
	private String categoryName;
	private String categoryDescription;

	public ReqCategoryCreate() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
}
