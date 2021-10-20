package project04;

//1.Contact - 프로젝트2의 contact상속
//-기본정보저장 기본정보출략
//-생성자로기존정보초기화

//2.거래처정보를 저장하는 하위클래스
//CustomerContact
//-거래처회사이름,거래품목,직급변수추가
//-정보출력하는 메소드를 오버라이딩,
//-추가된 정보를추가해서출력
public class CustomerContact extends Contact {

	//변수추가
	private String customerCompName;			
	private String item;
	private String position;
	
	//getter setter
	public String getCustomerCompName() {
		return customerCompName;
	}


	public void setCustomerCompName(String customerCompName) {
		this.customerCompName = customerCompName;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	//생성자-초기화
	public CustomerContact(String name, String phone, String email, String adress, String birthday, String group, String customerCompName, String item, String position) {
		super(name, phone, email, adress, birthday, group);
		this.customerCompName = customerCompName;
		this.item = item;
		this.position = position;
		
	}
	
	
	//출력메소드 오버라이딩
	@Override
	public void showData() {
		
		System.out.println("----------------------------");
		System.out.println("이름 :" + getName());
		System.out.println("전화번호 :" + getPhone());
		System.out.println("이메일 :" + getEmail());
		System.out.println("주소 :" + getAdress());
		System.out.println("생일 :" + getBirthday());
		System.out.println("그룹 :" + getGroup());
		System.out.println("거래처 회사이름 :" + customerCompName);
		System.out.println("거래품목 :" + item);
		System.out.println("직급 :" + position);
	}
	

	
	
	
}
