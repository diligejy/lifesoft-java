package ch41_canvas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProgressExam extends JFrame {

	private JPanel contentPane;
	private JProgressBar progress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressExam frame = new ProgressExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProgressExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		progress = new JProgressBar();
		contentPane.add(progress);

		JButton btnStart = new JButton("시작");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 프로그레스바의 값 변경
				/*
				 * for(int i=1; i<=100; i++) { progress.setValue(i); try { Thread.sleep(100); }
				 * catch (InterruptedException e) { e.printStackTrace(); } }
				 * progress.setValue(100); JOptionPane.showMessageDialog(ProgressExam.this,
				 * "완료되었습니다.");
				 */
				Thread th = new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 1; i <= 100; i++) {
							progress.setValue(i);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(ProgressExam.this, "완료되었습니다.");
					}
				});
				th.start();

			}

		});
		contentPane.add(btnStart);
	}

}
