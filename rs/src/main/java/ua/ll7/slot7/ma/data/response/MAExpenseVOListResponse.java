package ua.ll7.slot7.ma.data.response;

import ua.ll7.slot7.ma.data.generic.MAGenericResponse;
import ua.ll7.slot7.ma.data.vo.ExpenseVO;

import java.util.List;

/**
 * @author Alex Velichko
 *         05.01.15 : 16:39
 */
public class MAExpenseVOListResponse extends MAGenericResponse {
	private List<ExpenseVO> data1;

	public MAExpenseVOListResponse() {
	}

	public MAExpenseVOListResponse(List<ExpenseVO> data1) {
		this.data1 = data1;
	}

	@Override
	public String toString() {
		return "MAExpenseVOListResponse{" +
												 "data1=" + data1 +
												 "} " + super.toString();
	}

	public List<ExpenseVO> getData1() {
		return data1;
	}

	public void setData1(List<ExpenseVO> data1) {
		this.data1 = data1;
	}
}
