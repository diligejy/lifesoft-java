package ch37_event;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEvent1 extends JFrame {
	private JButton button1, button2, button3, button4, button5;

	public ButtonEvent1() {
		// JFrame의 기본레이아웃(BorderLayout)을 사용하지 않고
		// 플로우레이아웃으로 변경
		setLayout(new FlowLayout());
		// 버튼 생성
		button1 = new JButton("Red");
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		button4 = new JButton("White");
		button5 = new JButton("Yellow");

		// 프레임에 버튼을 붙임
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		// 버튼 클릭 이벤트 처리
		// 버튼 클릭 => 액션이벤트 발생
		// ActionListener를 통해서 액션이벤트가 호출됨
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// getContentPane() => 프레임의 콘텐츠 영역
				// 배경색상을 변경시킴
				getContentPane().setBackground(Color.red);
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.GREEN);
			}
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.BLUE);
			}
		});

		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.WHITE);
			}
		});
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.YELLOW);
			}
		});
		setSize(450, 300); // 프레임의 사이즈 설정
		setVisible(true); // 프레임을 화면에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 동작
	}

	public static void main(String[] args) {
		new ButtonEvent1();
	}
}
