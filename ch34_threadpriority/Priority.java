package ch34_threadpriority;

public class Priority extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 5000; i++) {
			// 현재 실행중인 스레드의 이름을 출력
			System.out.println(Thread.currentThread().getName() + "==>" + i);
		}
	}

	// main 스레드
	public static void main(String[] args) {
		// 백그라운드 스레드 생성
		Priority e1 = new Priority();
		Priority e2 = new Priority();
		e1.setName("스레드1");
		e2.setName("스레드2");
		// 스레드2에 최고 우선순위 설정
		// 1(최저) ~ 10(최고), 5(기본)
		e2.setPriority(Thread.MAX_PRIORITY);
		e1.start(); // run()이 실행됨
		e2.start();
	}
}
