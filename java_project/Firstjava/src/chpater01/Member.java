package chpater01;


public class Member {
	// Member Ŭ������ �����ϰ�, 
	// main()�޼ҵ带 ����� �ڱ� �ڽ��� �̸��� ����ϴ� �޼ҵ带 ����� ����� ���ô�.
	public static void main(String[] args) {
		//static : ����Ʈ�ڵ尡 ����ӽſ��� �����ϴ� ������ �޼ҵ� �ڵ尡 �޸��  �ε�ȴ�.
		System.out.println("������");
		System.out.println("�޼ҵ� ȣ��");
		System.out.println();
		sayName();
	}
	
	//�̸��� ����ϴ� �޼ҵ�
	//��ȯŸ�� �޼ҵ��̸� (�Ű�����,...)
	static void sayName() {
		System.out.println("������");
	}
	
	

}
