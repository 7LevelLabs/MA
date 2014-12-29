package ua.ll7.slot7.ma.data.vo;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:39
 */
public class CategoryForTheUserVO {

	private long id;

	private long userId;

	private String name;

	private String description;

	public CategoryForTheUserVO() {
	}

	public CategoryForTheUserVO(long id, long userId, String name, String description) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CategoryForTheUserVO{");
		sb.append("id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", name='").append(name).append('\'');
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
