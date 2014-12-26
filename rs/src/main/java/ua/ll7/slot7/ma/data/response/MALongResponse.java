package ua.ll7.slot7.ma.data.response;

import ua.ll7.slot7.ma.data.generic.MAGenericResponse;

/**
 * MA
 * Velichko A.
 * 26.12.14 18:18
 */
public class MALongResponse extends MAGenericResponse {
  private long data1;

  @Override
  public String toString() {
    return "MALongResponse{" +
                         "data1=" + data1 +
                         "} " + super.toString();
  }

  public long getData1() {
    return data1;
  }

  public void setData1(long data1) {
    this.data1 = data1;
  }
}
