package chpater02;

public class Member2 {
	// ���� = ��������� �����Ѵ�
	// ������ �����ϸ� �������(�޸��� �������)�� ����� 
	// ��������� �����ּҰ� �����
	// ������ �����ϰ� �� ���� ��������� ���� �Է��ϰ� �Ǵ°�
	// �Է��ϴ� �����Ϳ� ���� ��������� �����ϴ� ���̰� �׷��� �⺻��Ÿ���� ����.(�����Ǽ����ڳ�)
	// ����>�޸𸮰����� ����� ã�ư� �� �ִ� �ּ�>��������>�а� �����ϰԵǴ� ��
	// �����ϳ����� = ���� / Ÿ�Կ� ���ֹ����ʰ� ���� = Ŭ���� / ����Ÿ���� ���� = �迭
	
	/*
	�� String Ÿ���� �̸��� ������ �� �ִ� ���� name�� �����غ��ô�.
	�� int Ÿ���� ���̸� ������ �� �ִ� ���� age�� �����غ��ô�.
	�� double Ÿ���� Ű�� ������ �� �ִ� ���� height�� �����غ��ô�.
	�� boolean Ÿ���� JAVAå�� ���� ���θ� ������ �� �ִ� ���� hasBook�� �����غ��ô�.
	�� �̸��� ����, Ű, å�� ���� ���θ� ����غ��ô�.
	*/
	
	// Ŭ���� ����
	// [����������] [final] Ŭ���� �̸� {}
	// final = ����� �ȵȴٴ� ��. 
	// {
	//	 ��������
	//	 �޼ҵ� ����
	// }
	// �ν��Ͻ������� �ڵ��ʱ�ȭ
	// �ν��Ͻ����� �ʱ�ȭ�����ʾƵ���. ���������� �ؾ���.
	String name;    //null, �̸��� �����ϴ� ����
	int age;        //������� ���̸� �����ϴ� ����
	double height;  //������� Ű�� �����ϴ� ����
	boolean hasBook;//�ڹ�å ���� ���θ� �����ϴ� ����
	
	//ȸ���� �����͸� ����ϴ� �޼ҵ�
	void printData() {
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
		System.out.println("Ű: " + height);
		System.out.println("�ڹ� å ��������: " + hasBook);
	}
	
	//�� �̸��� ����, Ű, å�� ���� ���θ� ����غ��ô�.
	public static void main(String[] args) {
		
		long jn = 9701011111111L; //literral����� int�� long���� ��ȯ��.
		
		
		//Member Ŭ������ �ν��Ͻ��� ���� -> �̸�, ����, Ű, å�������� ������ �� �ִ� �޸𸮰����� ����
		Member2 member = new Member2();//�����ϱ����ؼ�! �ؿ�member.age�� ���������̴�
		
		//�ν��Ͻ��� ������ �����ؼ� ���
//		System.out.println("�̸�: " + member.name);
//		System.out.println("����: " + member.age);
//		System.out.println("Ű: " + member.height);
//		System.out.println("�ڹ� å ��������: " + member.hasBook);
		
		member.printData();		
		
		// �ν��Ͻ������� ���� ����
		member.name = "������";
		member.age = 27;
		member.height = 169.7;
		member.hasBook = false;
				
		System.out.println();
		System.out.println("�ν��Ͻ������� ���� ����");
		System.out.println();
		
//		System.out.println("�̸�: " + member.name);
//		System.out.println("����: " + member.age);
//		System.out.println("Ű: " + member.height);
//		System.out.println("�ڹ� å ��������: " + member.hasBook); //�̷��� �ߺ��Ǵ� �ڵ带 �޼ҵ�� �����ع�����!
		
		// �����ڵ�� -> �޼ҵ�� ���� => Member Ŭ�������� �޼ҵ带 ����
		member.printData();		
		
	}
	
	
	
}
