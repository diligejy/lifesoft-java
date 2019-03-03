package ch35_threadsync;

public class ATM extends Thread {
	private long depositMoney = 100000; // 잔액 10만원

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			withDraw(10000); // 만원 인출
			try {
				Thread.sleep(1000); // 1초간 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// synchronized 스레드의 동기화
	// 멀티스레드의 예외 영역(순차적으로 진행됨)
	// 임계영역
	public synchronized void withDraw(int money) {
		if (depositMoney > 0) {
			depositMoney -= money;
			System.out.println(Thread.currentThread().getName() + "-잔액:" + depositMoney);
		} else {
			System.out.println(Thread.currentThread().getName() + "-잔액이 없습니다.");
		}
	}
}
