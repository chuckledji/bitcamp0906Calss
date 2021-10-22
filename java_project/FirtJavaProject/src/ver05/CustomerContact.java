package ver05;

public class CustomerContact extends Contact {
	
	//변수
	
	private String companyName;
	private String product;
	private String job;
	
	//생성자
	
	public CustomerContact(String name, String phoneNumber, String email, String adress, String birthday, String group,
			String companyName, String product, String job) {
		super(name, phoneNumber, email, adress, birthday, group);
		this.companyName = companyName;
		this.product = product;
		this.job = job;
	}

	//생성자
	
	public CustomerContact(String name, String phoneNumber, String email, String adress, String birthday,
			String group) {
		super(name, phoneNumber, email, adress, birthday, group);
		
	}

	//getter setter
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
	@Override
	public void printContact() {
		super.printContact();
		System.out.println("거래처회사이름: "+companyName);
		System.out.println("거래품목: "+product);
		System.out.println("담당자 직급: "+job);
	}
	
	
	
	
}
