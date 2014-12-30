package ua.ll7.slot7.ma.data.response;

import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.vo.CategoryForTheUserVO;

import java.util.List;

/**
 * MA
 * Velichko A.
 * 30.12.14 15:27
 */
public class MACategoryForTheUserVOListResponse extends MAGenericResponse {
  private List<CategoryForTheUserVO> data1;

  @Override
  public String toString() {
    return "MACategoryForTheUserVOListResponse{" +
                         "data1=" + data1 +
                         "} " + super.toString();
  }

  public List<CategoryForTheUserVO> getData1() {
    return data1;
  }

  public void setData1(List<CategoryForTheUserVO> data1) {
    this.data1 = data1;
  }
}
