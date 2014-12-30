package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringLongDG;

/**
 * MA
 * Velichko A.
 * 30.12.14 17:26
 */
public class ExpenseCreateRequest extends StringLongDG {
  private double data3;

  @Override
  public String toString() {
    return "ExpenseCreateRequest{" +
                         "data3=" + data3 +
                         "} " + super.toString();
  }

  public double getData3() {
    return data3;
  }

  public void setData3(double data3) {
    this.data3 = data3;
  }
}
