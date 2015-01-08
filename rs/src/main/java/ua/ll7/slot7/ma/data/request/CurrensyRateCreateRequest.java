package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.StringStringDG;

/**
 * @author velichko
 *         on 08.01.15 : 16:08
 */
public class CurrensyRateCreateRequest extends StringStringDG {
  private float data3;

  public CurrensyRateCreateRequest() {
  }

  public CurrensyRateCreateRequest(String data1, String data2, float data3) {
    super(data1, data2);
    this.data3 = data3;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CurrensyRateCreateRequest{");
    sb.append("data3=").append(data3);
    sb.append('}');
    return sb.toString();
  }

  public float getData3() {
    return data3;
  }

  public void setData3(float data3) {
    this.data3 = data3;
  }
}
