package ua.ll7.slot7.ma.model;

import javax.persistence.*;
import java.util.Date;

/**
 * MA
 * Velichko A.
 * 24.02.15 13:49
 */
@Entity
@Table(indexes = {
       @Index(
              columnList = "executedate")
}
)
public class EMailTask {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  private User user;

  @Column(nullable = false)
  private String emailSubject;

  @Column(nullable = false)
  private String emailBody;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  private Date executeDate;

  @Column(nullable = false)
  private boolean executed;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("EMailTask{");
    sb.append("id=").append(id);
    sb.append(", user=").append(user.getId());
    sb.append(", emailSubject='").append(emailSubject).append('\'');
    sb.append(", emailBody='").append(emailBody).append('\'');
    sb.append(", executeDate=").append(executeDate);
    sb.append(", executed=").append(executed);
    sb.append('}');
    return sb.toString();
  }

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

  public String getEmailSubject() {
    return emailSubject;
  }

  public void setEmailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
  }

  public String getEmailBody() {
    return emailBody;
  }

  public void setEmailBody(String emailBody) {
    this.emailBody = emailBody;
  }

  public Date getExecuteDate() {
    return executeDate;
  }

  public void setExecuteDate(Date executeDate) {
    this.executeDate = executeDate;
  }

  public boolean isExecuted() {
    return executed;
  }

  public void setExecuted(boolean executed) {
    this.executed = executed;
  }
}
