package day1015;

public class Student {
	
	//①학생이름, 국어점수, 영어점수, 수학점수를 저장하는 변수를 정의 합니다.
	private int kor;
	private int math;
	private int eng;
	
	//②변수는 캡슐화를 합니다. getter/setter 메소드를 정의합니다.
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	// ③총점과 평균을 구해 결과를 반환하는 메소드를 정의합니다.
	public float sum() {
		Student student = new Student();
		int sum = student.getEng() + student.getKor() + student.getMath()
	}
	
	
	public float avg() {
		
	}
	
	
}
