package ch39_radiocheck;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CheckboxExam extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckboxExam frame = new CheckboxExam();
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
	public CheckboxExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JCheckBox ckJava = new JCheckBox("자바");
		ckJava.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// ItemEvent.SELECTED 체크상태
				// ItemEvent.DESELECTED 체크해제상태
				// JTextArea.append() 텍스트를 추가
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("Java를 신청했습니다\n.");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("Java를 취소했습니다 \n.");
				}
			}
		});
		panel.add(ckJava);

		JCheckBox ckC = new JCheckBox("C언어");
		ckC.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("C언어를 신청했습니다\n.");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("C언어를 취소했습니다 \n.");
				}
			}
		});
		panel.add(ckC);

		JCheckBox ckIot = new JCheckBox("사물인터넷");
		ckIot.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ta.append("사물인터넷을 신청했습니다\n.");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					ta.append("사물인터넷을 취소했습니다 \n.");
				}
			}
		});
		ckIot.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(ckIot);

		JCheckBox ckDB = new JCheckBox("데이터베이스");
		ckDB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {				
				putResult(e);
			}
		});
		panel.add(ckDB);

		JButton btnExit = new JButton("종료");
		contentPane.add(btnExit, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);

	}

	void putResult(ItemEvent e) {

		JCheckBox ck = (JCheckBox) e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			ta.append(ck.getText() + "를 신청했습니다\n.");
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			ta.append(ck.getText() + "를 취소했습니다 \n.");
		}
	}
}
