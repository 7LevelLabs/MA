package ua.ll7.slot7.ma.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 13:41
 */

/**
 * System user. Key field : {@link #email}
 */
@Entity
@Table(indexes = {
  @Index(
    columnList = "email")
}
)
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "User's EMail must be not blank")
  @Column(nullable = false, unique = true)
  private String email;

  @NotBlank(message = "User's Password must be not blank")
  @Column(nullable = false)
  private String password;

  @NotBlank(message = "User's Nick must be not blank")
  @Column(nullable = false)
  private String nick;

  @NotBlank(message = "User's Name must be not blank")
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "User's API code must be not blank")
  private String apiCode;

  @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "user",
    cascade = {CascadeType.ALL})
  private List<CategoryForTheUser> categories;

  @Column(nullable = false)
  private int role = 1;

  @Column(nullable = false)
  private boolean active;

  @Version
  private long version;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public List<CategoryForTheUser> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryForTheUser> categories) {
    this.categories = categories;
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

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

  @Override
  public int hashCode() {
    return email.hashCode();
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
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", email='").append(email).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", nick='").append(nick).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", apiCode='").append(apiCode).append('\'');
    sb.append(", categories=").append(categories);
    sb.append(", role=").append(role);
    sb.append(", active=").append(active);
    sb.append(", version=").append(version);
    sb.append('}');
    return sb.toString();
  }

}
