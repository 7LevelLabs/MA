package ua.ll7.slot7.ma.data.response;

import ua.ll7.slot7.ma.data.generic.MAGenericResponse;

/**
 * @author velichko
 *         on 08.01.15 : 16:48
 */
public class MACurrencyRateCurrentResponse extends MAGenericResponse {

  private float data1;

  @Override
  public String toString() {
    return "MACurrencyRateCurrentResponse{" +
           "data1=" + data1 +
           "} " + super.toString();
  }

  public float getData1() {
    return data1;
  }

  public void setData1(float data1) {
    this.data1 = data1;
  }
}
