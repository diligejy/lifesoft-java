package ch40_jcombobox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListExam extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JList list;
	// JList에 목록을 출력하기 위해 모델 추가
	private DefaultListModel<String> model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListExam frame = new ListExam();
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
	public ListExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		tf = new JTextField();
		tf.addActionListener(new ActionListener() {
			// 텍스트필드에서 엔터키를 입력했을 때
			public void actionPerformed(ActionEvent e) {
				model.addElement(tf.getText());
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(tf);
		tf.setColumns(10);

		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 텍스트필드에 입력한 내용을 모델에 추가(리스트가 갱신됨)
				model.addElement(tf.getText());
				// 입력 커서 이동
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(btnAdd);

		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JList에서 선택된 아이템의 인덱스값
				int index = list.getSelectedIndex();
				// 인덱스값에 해당하는 내용을 삭제
				if (index != -1) {
					model.remove(index);
				}else {
					JOptionPane.showMessageDialog(ListExam.this, "삭제할 내용을 선택하세요.");
				}
			}
		});
		panel.add(btnDelete);

		// JList에 추가할 모델 작성
		model = new DefaultListModel<>();
		model.addElement("서울");
		model.addElement("부산");
		model.addElement("대전");
		model.addElement("인천");
		model.addElement("춘천");
		// JList에 모델을 연결시킴
		list = new JList<String>(model);
		contentPane.add(list, BorderLayout.CENTER);
	}

}
