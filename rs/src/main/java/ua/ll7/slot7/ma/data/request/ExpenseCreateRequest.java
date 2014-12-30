package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringLongDG;

/**
 * MA
 * Velichko A.
 * 30.12.14 17:26
 */
public class ExpenseCreateRequest extends StringLongDG {
  private float data3;

  @Override
  public String toString() {
    return "ExpenseCreateRequest{" +
                         "data3=" + data3 +
                         "} " + super.toString();
  }

  public float getData3() {
    return data3;
  }

  public void setData3(float data3) {
    this.data3 = data3;
  }
}
