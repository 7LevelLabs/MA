package ua.ll7.slot7.ma.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author velichko
 *         on 08.01.15 : 13:38.
 */

/**
 * Currency rate: the result of dividing the currencyCode1 on currencyCode2
 */
@Entity
@Table(indexes = {
       @Index(
              columnList = "currencyCode1")
}
)
public class CurrencyRate implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String currencyCode1;

  @Column
  private String currencyCode2;

  @Temporal(TemporalType.TIMESTAMP)
  private Date registered = new Date();

  @NotNull(message = "Currency rate must be not null")
  @Column
  private float rate;

  @Version
  private long version;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CurrencyRate that = (CurrencyRate) o;

    if (!currencyCode1.equals(that.currencyCode1)) return false;
    if (!currencyCode2.equals(that.currencyCode2)) return false;
    if (!registered.equals(that.registered)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = currencyCode1.hashCode();
    result = 31 * result + currencyCode2.hashCode();
    result = 31 * result + registered.hashCode();
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CurrencyRate{");
    sb.append("id=").append(id);
    sb.append(", currencyCode1='").append(currencyCode1).append('\'');
    sb.append(", currencyCode2='").append(currencyCode2).append('\'');
    sb.append(", registered=").append(registered);
    sb.append(", rate=").append(rate);
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

  public String getCurrencyCode1() {
    return currencyCode1;
  }

  public void setCurrencyCode1(String currencyCode1) {
    this.currencyCode1 = currencyCode1;
  }

  public String getCurrencyCode2() {
    return currencyCode2;
  }

  public void setCurrencyCode2(String currencyCode2) {
    this.currencyCode2 = currencyCode2;
  }

  public Date getRegistered() {
    return registered;
  }

  public void setRegistered(Date registered) {
    this.registered = registered;
  }

  public float getRate() {
    return rate;
  }

  public void setRate(float rate) {
    this.rate = rate;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }
}
