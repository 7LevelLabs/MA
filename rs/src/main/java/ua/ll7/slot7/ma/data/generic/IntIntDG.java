package ua.ll7.slot7.ma.data.generic;

/**
 * @author Alex Velichko
 *         05.01.15 : 15:13
 */
public class IntIntDG {
	private int data1;
	private int data2;

	public IntIntDG() {
	}

	public IntIntDG(int data1, int data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("IntIntDG{");
		sb.append("data1=").append(data1);
		sb.append(", data2=").append(data2);
		sb.append('}');
		return sb.toString();
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}
}
