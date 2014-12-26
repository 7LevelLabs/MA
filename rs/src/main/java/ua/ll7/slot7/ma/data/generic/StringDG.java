package ua.ll7.slot7.ma.data.generic;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:31
 */
public class StringDG {
  private String data1;

  public StringDG() {
  }

  public StringDG(String data1) {
    this.data1 = data1;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StringDG{");
    sb.append("data1='").append(data1).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public String getData1() {
    return data1;
  }

  public void setData1(String data1) {
    this.data1 = data1;
  }
}
