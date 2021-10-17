package project02;

import java.util.Scanner;

public class Member {
	public static final Scanner scanner = new Scanner(System.in);
	
	
	//캡슐화처리
	private String name;
	private String phone;
	private String email;
	private String adress;
	private String birthday;
	private String group;
	
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
	
	//생성자
	Member(){}
	
	public Member(String name, String phone, String email, String adress, String birthday, String group) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
		this.birthday = birthday;
		this.group = group;
	}
	
	
			
		@Override
		public String toString() {
			return "Member [name=" + name + ", phone=" + phone + ", email=" + email + ", adress=" + adress
					+ ", birthday=" + birthday + ", group=" + group + "]";
		}
		
	}
