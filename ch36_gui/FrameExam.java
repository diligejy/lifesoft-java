package ch36_gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameExam {
	public static void main(String[] args) {
		// 프레임 생성
		Frame f = new Frame();
		// 프레임의 제목 설정
		f.setTitle("프레임 테스트");
		// 프레임의 가로, 세로 사이즈 설정
		f.setSize(300, 300);
		// 프레임을 화면에 표시
		f.setVisible(true);
		// 프레임에 윈도우 이벤트를 감시하는 리스너 기능을 붙임
		// 윈도우가 닫히면 프로그램을 강제로 종료함
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
