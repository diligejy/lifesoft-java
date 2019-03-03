package ch36_gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridExam extends JFrame {
	public GridExam() {
		// 기본 레이아웃을 사용하지 않고
		// 그리드 레이아웃(2행 3열)으로 변경
		this.setLayout(new GridLayout(2, 3)); // 2행 3열의 그리드 레이아웃
		for (int i = 1; i <= 6; i++) {
			JButton button = new JButton("버튼" + i);
			this.add(button);
		}

		// 프레임 설정
		this.setSize(300, 300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GridExam();
	}
}
