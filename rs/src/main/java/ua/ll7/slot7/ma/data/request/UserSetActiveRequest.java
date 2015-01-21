package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringDG;

/**
 * MA
 * Velichko A.
 * 21.01.15 16:58
 */
public class UserSetActiveRequest extends StringDG {

  private boolean data2;

  @Override
  public String toString() {
    return "UserSetActiveRequest{" +
           "data2=" + data2 +
           "} " + super.toString();
  }

  public boolean isData2() {
    return data2;
  }

  public void setData2(boolean data2) {
    this.data2 = data2;
  }
}
