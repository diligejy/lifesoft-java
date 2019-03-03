package ch36_gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderExam extends JFrame {
	public BorderExam() {
		setTitle("BorderLayout 테스트"); // 타이틀 설정
		JButton button1 = new JButton("버튼1");// 버튼 생성
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");
		JButton button5 = new JButton("버튼5");
		JButton button6 = new JButton("버튼6");
		add(button1);// 프레임에 버튼을 붙임
		add(button2, "North");
		add(button3, "South");
		add(button4, "East");
//		add(button5, "West");
//		add(button6, "West");
		JPanel p = new JPanel(); // 패널생성
		p.add(button5); // 패널에 버튼을 붙임
		p.add(button6);
		add(p, "West"); // West영역에 패널을 붙임

		setSize(300, 200); // 화면 사이즈 설정
		setVisible(true); // 화면에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 닫기 설정
	}

	public static void main(String[] args) {
		new BorderExam(); // 생성자가 자동으로 호출됨
	}
}
