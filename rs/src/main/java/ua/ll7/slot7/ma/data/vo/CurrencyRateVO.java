package ua.ll7.slot7.ma.data.vo;

/**
 * @author velichko
 *         on 08.01.15 : 16:26
 */
public class CurrencyRateVO {
  private String currencyCode1;

  private String currencyCode2;

  private long registered;

  private float rate;

  public CurrencyRateVO() {
  }

  public CurrencyRateVO(String currencyCode1, String currencyCode2, long registered, float rate) {
    this.currencyCode1 = currencyCode1;
    this.currencyCode2 = currencyCode2;
    this.registered = registered;
    this.rate = rate;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CurrencyRateVO{");
    sb.append("currencyCode1='").append(currencyCode1).append('\'');
    sb.append(", currencyCode2='").append(currencyCode2).append('\'');
    sb.append(", registered=").append(registered);
    sb.append(", rate=").append(rate);
    sb.append('}');
    return sb.toString();
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

  public long getRegistered() {
    return registered;
  }

  public void setRegistered(long registered) {
    this.registered = registered;
  }

  public float getRate() {
    return rate;
  }

  public void setRate(float rate) {
    this.rate = rate;
  }
}
