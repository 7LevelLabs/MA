package ua.ll7.slot7.ma.model;

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
  @GeneratedValue
  private Long id;

  @NotNull(message = "User for this CategoryForTheUser must be not null")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private User user;

  @NotBlank(message = "CategoryForTheUser Name must be not blank")
  @Column(nullable = false)
  private String name;

  @NotBlank(message = "CategoryForTheUser Description must be not blank")
  @Column(nullable = false)
  private String description;

  @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "categoryForTheUser",
    cascade = {CascadeType.ALL})
  private List<Expense> expenses = new LinkedList<Expense>();

  @Version
  private long version;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public List<Expense> getExpenses() {
    return expenses;
  }

  public void setExpenses(List<Expense> expenses) {
    this.expenses = expenses;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Override
  public int hashCode() {
    int result = user.hashCode();
    result = 31 * result + name.hashCode();
    return result;
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

}
