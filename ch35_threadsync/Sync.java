package ch35_threadsync;

public class Sync {
	public static void main(String[] args) {
		//스레드를 상속받은 클래스의 객체 생성
		ATM atm = new ATM();
		//스레드 생성 new THread(스레드 구현 클래스, 스레드이름)
		Thread mom = new Thread(atm, "mom");
		Thread son = new Thread(atm, "son");
		//스레드 실행 요청, run()이 실행됨
		mom.start();
		son.start();
	}
}
