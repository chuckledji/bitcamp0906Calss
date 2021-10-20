package project04;

import java.util.Scanner;

public abstract class Contact implements ShowData{
	
	
	
	private String name;
	private String phone;
	private String email;
	private String adress;
	private String birthday;
	private String group;
	
	//getter setter
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
	public Contact(String name, String phone, String email, String adress, String birthday, String group) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
		this.birthday = birthday;
		this.group = group;
	}
	
	public void printOne() {
		System.out.println("----------------------------");
		System.out.println("이름 :" + name);
		System.out.println("전화번호 :" + phone);
		System.out.println("이메일 :" + email);
		System.out.println("주소 :" + adress);
		System.out.println("생일 :" + birthday);
		System.out.println("그룹 :" + group);
		
	}
	
	public abstract void showData();
	
		@Override
		public String toString() {
			return name + "\t" + phone + "\t" + email + "\t" + adress
					+ "\t" + birthday + "\t" + group;
		}
		
	}
