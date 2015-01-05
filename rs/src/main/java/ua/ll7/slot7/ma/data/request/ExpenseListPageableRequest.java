package ua.ll7.slot7.ma.data.request;

import ua.ll7.slot7.ma.data.generic.IntIntDG;

/**
 * @author Alex Velichko
 *         05.01.15 : 16:41
 */
public class ExpenseListPageableRequest extends IntIntDG {
	//expense category id
	private long data3;

	public ExpenseListPageableRequest() {
	}

	public ExpenseListPageableRequest(long data3) {
		this.data3 = data3;
	}

	@Override
	public String toString() {
		return "ExpenseListRequest{" +
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
