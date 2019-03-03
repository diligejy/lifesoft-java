package ch33_multithreadjoin;

public class ThreadJoin extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName() + "스레드 시작...");
		System.out.println(Thread.currentThread().getName() + "스레드 종료...");
	}

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + "스레드 시작...");
		ThreadJoin e = new ThreadJoin();
		e.setName("백그라운드 스레드");
		e.start();
		try {
			// 현재 스레드(백그라운드 스레드)가 종료될 때까지
			// 다른 스레드(메인 스레드)의 실행을 중지시킴
			e.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "스레드 종료...");

	}

}
