package ch37_event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class EventExam1 extends Frame {
	public EventExam1() {
		setSize(300, 300); // 프레임의 사이즈 설정
		setVisible(true); // 프레임을 화면에 표시
		// 이벤트소스.이벤트리스너(이벤트핸들러)
		// add대상Listener

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
				System.exit(0);
			}
		});
	}

	/*
	 * addWindowListener(new WindowListener() {
	 * 
	 * @Override public void windowActivated(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void windowClosed(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void windowClosing(WindowEvent arg0) { // 메시지 박스 출력
	 * JOptionPane.showMessageDialog(null, "프로그램을 종료합니다"); System.exit(0); }
	 * 
	 * @Override public void windowDeactivated(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void windowDeiconified(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void windowIconified(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * @Override public void windowOpened(WindowEvent arg0) {
	 * 
	 * }
	 * 
	 * }); }
	 */

	public static void main(String[] args) {
		new EventExam1();
	}
}
