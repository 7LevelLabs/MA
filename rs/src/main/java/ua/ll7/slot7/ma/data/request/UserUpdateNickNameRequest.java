package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringLongDG;

/**
 * MA
 * Velichko A.
 * 27.01.15 8:50
 */
public class UserUpdateNickNameRequest extends StringLongDG {

  private String data2;

  @Override
  public String toString() {
    return "UserUpdateNickNameRequest{" +
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
