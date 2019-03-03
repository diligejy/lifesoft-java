package ch32_multithread;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class anim extends Applet implements Runnable {

	// 이미지 객체 배열 참조변수
	private Image[] img;// java.awt
	// 이미지의 인덱스값(0~9)
	private int idx;

	// 애플릿을 초기화하는 코드
	public void init() {
		// 이미지 객체배열 생성
		img = new Image[10];
		// 이미지 10장을 불러옴
		for (int i = 0; i < img.length; i++) {
			// getClass() 현재 클래스의 정보
			// getClass().getResource() 현재클래스와 같은 패키지의 리소스를 불러오는 코드
			img[i] = Toolkit.getDefaultToolkit().getImage(getClass().getResource("duke" + (i + 1) + ".gif"));

		}
		// 백그라운드 스레드 생성
		// new Thread(Runnable을 구현한 객체)
		Thread t = new Thread(this);
		// 백그라운드 스레드 실행 요청
		t.start();
		// 화면 사이즈 설정
		setSize(500, 200);
	}

	public void paint(Graphics g) {
		// drawImage(이미지, x좌표, y좌표, 이미지관찰자)
		g.drawImage(img[idx], 40, 73, this);
		/*
		 * for(int i=0; i<img.length; i++) { g.drawImage(img[i], i*40, 73, this);
		 * 
		 * }
		 */
	}

	@Override
	// 백그라운드 스레드에서 실행하는 코드(이미지 인덱스 변경)
	public void run() {
		while (true) {// 무한반복
			idx++; // 이미지 인덱스값 증가
			if (idx >= 10) {// 10이 되면 다시 0으로
				idx = 0;
			}
			repaint(); // 그래픽 갱신 요청 => paint() 호출됨
			try {
				Thread.sleep(30); // 잠시 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
