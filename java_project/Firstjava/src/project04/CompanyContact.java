package project04;

//1.Contact - 프로젝트2의 contact상속
//-기본정보저장 기본정보출략
//-생성자로기존정보초기화

//2.회사정보를 저장하는 하위클래스
//CompanyContact
//-회사이름, 부서이름, 직급변수 추가
//-정보출력하는 메소드를 오버라이딩, 추가된 정보를추가해서출력
public class CompanyContact extends Contact {

	//변수추가
	private String companyName;			
	private String department;
	private String position;
	
	
	//getter setter
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	//생성자-초기화
	public CompanyContact(String name, String phone, String email, String adress, String birthday, String group, String companyName, String department, String position) {
		super(name, phone, email, adress, birthday, group);
		this.companyName = companyName;
		this.department = department;
		this.position = position;
		
	}
	
	
	//출력메소드 오버라이딩
	@Override
	public void printOne() {
		
		super.printOne();
		System.out.println("회사이름 :" + companyName);
		System.out.println("부서 :" + department);
		System.out.println("직급 :" + position);
	}
	

	
	
	
}
