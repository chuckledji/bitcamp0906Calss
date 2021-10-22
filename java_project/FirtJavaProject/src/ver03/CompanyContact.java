package ver03;

public class CompanyContact extends Contact {

	//변수 - 상속하고 새로운 변수 추가
	private String companyName;
	private String divName;
	private String job;
	
	//생성자1/////////////////////////////////////////////////////
	
	public CompanyContact(String name, String phoneNumber, String email, String adress, String birthday, String group,
			String companyName, String divName, String job) {
		
		//상위클래스의 생성자 호출
		super(name, phoneNumber, email, adress, birthday, group);
		
		this.companyName = companyName;
		this.divName = divName;
		this.job = job;
	}

	//생성자2////////////////////////////////////////////////////
	
	public CompanyContact(String name, String phoneNumber, String email, String adress, String birthday, String group) {
		super(name, phoneNumber, email, adress, birthday, group);
		
	}

	//getter setter///////////////////////////////////////////
	
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getDivName() {
		return divName;
	}


	public void setDivName(String divName) {
		this.divName = divName;
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
		System.out.println("회사이름: "+companyName);
		System.out.println("부서이름: "+divName);
		System.out.println("직급: "+job);
	}
}
