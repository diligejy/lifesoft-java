package ch36_gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//JFrame 상속
//컴포넌트(component) - 화면 구성 요소
//컨테이너(container) - 다른 화면 구성 요소를 담을 수 있음

public class PanelExam extends JFrame {
	public PanelExam() {
		JPanel p = new JPanel(); // 패널 생성
		p.setBackground(Color.red); // 패널의 배경색상 설정
		JButton button1 = new JButton("버튼1"); // 버튼 생성
		JButton button2 = new JButton("버튼2"); // 버튼 생성
		JButton button3 = new JButton("버튼3"); // 버튼 생성
		p.add(button1); // 패널에 버튼을 붙임
		p.add(button2);
		p.add(button3);
		add(p); // 프레임에 패널을 붙임
		setSize(300, 300); // 프레임의 사이즈 설정
		setVisible(true); // 프레임을 화면에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 닫기 설정
	}

	public static void main(String[] args) {
		// 객체가 만들어지면서 생성자가 자동으로 호출됨
		new PanelExam();
	}
}
