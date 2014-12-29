package ua.ll7.slot7.ma.data.generic;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:10
 */
public class StringLongDG extends StringDG {
	private long data0;

	public StringLongDG() {
	}

	public StringLongDG(String data1, long data0) {
		super(data1);
		this.data0 = data0;
	}

	@Override
	public String toString() {
		return "StringLongDG{" +
												 "data0=" + data0 +
												 "} " + super.toString();
	}

	public long getData0() {
		return data0;
	}

	public void setData0(long data0) {
		this.data0 = data0;
	}
}
