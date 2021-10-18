package chapter7_day1018.speaker;

public class Speaker {
	//변수
	private int volumeRate;
	
	//메소드1
	public void showCurrentState() {
		System.out.println("볼륨크기"+ volumeRate);
	}
	//메소드2
	public void setVolume(int vol) {
		volumeRate=vol;
	}
}
