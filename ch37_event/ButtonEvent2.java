package ch37_event;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ButtonEvent2 extends JFrame implements ActionListener {
	private JButton button1, button2, button3, button4, button5;

	public ButtonEvent2() {
		setLayout(new FlowLayout()); // 레이아웃변경
		button1 = new JButton("Red"); // 버튼생성
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		button4 = new JButton("White");
		button5 = new JButton("Yellow");
		// 버튼을 프레임에 붙임
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

		setSize(450, 300); // 프레임의 사이즈 설정
		setVisible(true); // 프레임을 화면에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 설정
	}

	public static void main(String[] args) {
		new ButtonEvent2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼의 아이디값
		System.out.println(e.getSource());
		// 버튼의 레이블(label)
		System.out.println(e.getActionCommand());
		if (e.getSource() == button1) {
			getContentPane().setBackground(Color.red);
		} else if (e.getSource() == button2) {
			getContentPane().setBackground(Color.green);
		} else if (e.getSource() == button3) {
			getContentPane().setBackground(Color.blue);
		} else if (e.getSource() == button4) {
			getContentPane().setBackground(Color.white);
		} else if (e.getSource() == button5) {
			getContentPane().setBackground(Color.yellow);
		}
	}

}
