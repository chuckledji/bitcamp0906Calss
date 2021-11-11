package member;

public class Delivery {

	private int addressnum;
	private String dname;
	private String dphn;
	private String daddr;
	
	//생성자 초기화
	public Delivery(int addressnum, String dname, String dphn, String daddr) {
		
		this.addressnum = addressnum;
		this.dname = dname;
		this.dphn = dphn;
		this.daddr = daddr;
	}
	
	//기본생성자(디폴트)
	public Delivery() {}


	//getter/setter
	public int getAddressnum() {
		return addressnum;
	}

	public void setAddressnum(int addressnum) {
		this.addressnum = addressnum;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDphn() {
		return dphn;
	}

	public void setDphn(String dphn) {
		this.dphn = dphn;
	}

	public String getDaddr() {
		return daddr;
	}

	public void setDaddr(String daddr) {
		this.daddr = daddr;
	}
	
	//to String
	@Override
	public String toString() {
		return  addressnum + "\t" + dname + "\t" + dphn + "\t" + daddr + "\t";
	}
	
	
	
	
	
	
}
