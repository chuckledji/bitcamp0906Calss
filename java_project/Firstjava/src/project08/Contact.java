package project08;

public class Contact {
	
	//저장 정보
	//이름 ,전화번호, 이메일, 주소, 생일, 그룹
	//캡슐화 : 외부(다른 인스턴스)에서 변수를 직접 참조하지 못하도록 하는 것  
	private String name;
	private String phoneNumber;		//000-0000-0000
	private String email;
	private String adress;
	private String birthday;		//20001020
	private String group;

	//생성자 : 인스턴스 변수들을 초기화 할 때 사용한다.(필수요소는 아닌 것)
	public Contact(String name, String phoneNumber, String email, String adress, String birthday, String group) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adress = adress;
		this.birthday = birthday;
		this.group = group;
	}
	
	public Contact(String name, String phoneNumber) {
		
//		this.name = name;
//		this.phoneNumber = phoneNumber;
		this(name, phoneNumber, null, null, null, null);
	}
	
	//객체만 있으면VO , 메소드도있으면DTO

	//getter setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	//기능 위 데이터를 출력하는 기능
	public void printContact() {
		System.out.println("이름 :"+name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("이메일: "+email);
		System.out.println("주소: "+adress);
		System.out.println("생일: "+birthday);
		System.out.println("그룹: "+group);
		
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", adress=" + adress
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}
	
//	public static void main(String[] args) { //메인 메소드는 아무데나 적어도 된다
//		
//	}
	
	
}
