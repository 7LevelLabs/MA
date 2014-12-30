package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringStringDG;

/**
 * MA
 * Velichko A.
 * 30.12.14 15:55
 */
public class CategoryUpdateRequest extends StringStringDG {
  private long data3;

  @Override
  public String toString() {
    return "CategoryUpdateRequest{" +
                         "data3=" + data3 +
                         "} " + super.toString();
  }

  public long getData3() {
    return data3;
  }

  public void setData3(long data3) {
    this.data3 = data3;
  }
}
