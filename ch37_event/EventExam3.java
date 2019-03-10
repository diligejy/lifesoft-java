package ch37_event;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class EventExam3 extends JFrame {
	private JButton button1, button2, button3, button4, button5;

	public EventExam3() {
		setLayout(new FlowLayout()); // 레이아웃변경
		button1 = new JButton("Red"); // 버튼 생성
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		button4 = new JButton("White");
		button5 = new JButton("Yellow");
		
		button1.addActionListener(new MyColorAction(this, Color.red));
		button2.addActionListener(new MyColorAction(this, Color.GREEN));
		button3.addActionListener(new MyColorAction(this, Color.blue));
		button4.addActionListener(new MyColorAction(this, Color.WHITE));
		button5.addActionListener(new MyColorAction(this, Color.yellow));
		
		// 프레임에 버튼 붙임
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		setSize(450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EventExam3();
	}
}
