package ua.ll7.slot7.ma.data.response;

import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.vo.UserVO;

import java.util.List;

/**
 * @author Alex Velichko
 *         05.01.15 : 13:55
 */
public class MAUserVOListResponse extends MAGenericResponse {
	private List<UserVO> data1;

	public MAUserVOListResponse() {
	}

	public MAUserVOListResponse(List<UserVO> data1) {
		this.data1 = data1;
	}

	@Override
	public String toString() {
		return "MAUserVOListResponse{" +
												 "data1=" + data1 +
												 "} " + super.toString();
	}

	public List<UserVO> getData1() {
		return data1;
	}

	public void setData1(List<UserVO> data1) {
		this.data1 = data1;
	}
}
