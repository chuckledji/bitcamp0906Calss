package chpater02;

public class Person {
	/*
	2. Person Ŭ������ ����� ����, �Ʒ��� ȸ�� ������ �����ϴ� �������� �����غ��ô�. 
	�����̸��� �ۼ��ϴ� ��Ģ�� �°� ���� ���� �̸��� ������ ������. 
	�� ȸ���̸��� �����ϴ� ����
	�� ȸ�� ��ȭ��ȣ ( 000-0000-0000 )�� �����ϴ� ����
	�� ȸ�� �ֹε�Ϲ�ȣ ( 000000-0000000 �Ǵ� 0000000000000 )�� �����ϴ� ����
	*/
	
	//private : Ŭ���� ���ο� ����鸸 ������ �����ϵ��� �ϴ� ���� ������
	
	private String memberName;//ȸ���̸�
	private String phoneNum;  //(�������������Ƿ� String)��ȭ��ȣ
	//private String juminNum;  //�ֹι�ȣ
	private long juminNum;   //�ֹι�ȣ
	
	//setter / getter ����(����) / ��������
	//setter => ���� �޾Ƽ� ������ ����
	//�������������� �Ķ����� �ν��Ͻ�
	public void setMemberName(String name) {
		memberName = name;
	}
	
	//getter => �ν��Ͻ������� ��ȯ
	public String getMemberName() {
		return memberName;
	}
	public void setPhoneNum(String num) {
		phoneNum = num;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setJuminNum(long num) {
		juminNum = num;
	}
	public long getJuminNum() {
		return juminNum;
	}
	
	//��ü ������ ���
	public void printData() {
		System.out.println("�̸�:" + memberName);
		System.out.println("��ȭ��ȣ:" + phoneNum);
		System.out.println("�ֹι�ȣ:" + juminNum);
	}
	
}
