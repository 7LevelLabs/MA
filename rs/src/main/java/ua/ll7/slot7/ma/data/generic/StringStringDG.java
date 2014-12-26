package ua.ll7.slot7.ma.data.generic;

/**
 * MA
 * Velichko A.
 * 26.12.14 17:32
 */
public class StringStringDG extends StringDG {
  private String data2;

  public StringStringDG() {
  }

  public StringStringDG(String data1, String data2) {
    super(data1);
    this.data2 = data2;
  }

  @Override
  public String toString() {
    return "StringStringDG{" +
                         "data2='" + data2 + '\'' +
                         "} " + super.toString();
  }

  public String getData2() {
    return data2;
  }

  public void setData2(String data2) {
    this.data2 = data2;
  }
}
