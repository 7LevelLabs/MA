package ua.ll7.slot7.ma.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * MA
 * Velichko A.
 * 13.02.15 18:48
 */
@Entity
@Table(indexes = {
       @Index(
              columnList = "email")
}
)
public class UserARToken implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "Access recovery EMail must be not blank")
  @Column(nullable = false)
  private String email;

  @Column
  @NotBlank(message = "Access recovery Token must be not blank")
  private String tokenCode;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date periodBegin;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date periodEnd;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserARToken that = (UserARToken) o;

    if (!email.equals(that.email)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return email.hashCode();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("UserARToken{");
    sb.append("id=").append(id);
    sb.append(", email='").append(email).append('\'');
    sb.append(", tokenCode='").append(tokenCode).append('\'');
    sb.append(", periodBegin=").append(periodBegin);
    sb.append(", periodEnd=").append(periodEnd);
    sb.append('}');
    return sb.toString();
  }

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

  public String getTokenCode() {
    return tokenCode;
  }

  public void setTokenCode(String tokenCode) {
    this.tokenCode = tokenCode;
  }

  public Date getPeriodBegin() {
    return periodBegin;
  }

  public void setPeriodBegin(Date periodBegin) {
    this.periodBegin = periodBegin;
  }

  public Date getPeriodEnd() {
    return periodEnd;
  }

  public void setPeriodEnd(Date periodEnd) {
    this.periodEnd = periodEnd;
  }
}
