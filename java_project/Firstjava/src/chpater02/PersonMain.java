package chpater02;

public class PersonMain {
	public static void main(String[] args) {
	
		//Person Ŭ������ �ν��Ͻ� ����
		Person p =new Person();
		
		//�� �����ϱ�
		//p.memberName ="������";
		p.setMemberName("������");
		p.setPhoneNum("010-2222-3333");
		p.setJuminNum(9901011111112L);//L�ٿ������
		
		//�ϳ��ϳ� ���ؼ� ����ҋ�
		System.out.println("�̸�:"+p.getMemberName());
		System.out.println("��ȭ��ȣ:"+p.getPhoneNum());
		System.out.println("�ֹι�ȣ:"+p.getJuminNum());
		
		
		System.out.println("--------------------------------");
		//��������� �޼ҵ�� ����Ҷ� 
		p.printData();
	}



}
