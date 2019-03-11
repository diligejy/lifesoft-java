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
	// JList�� ����� ����ϱ� ���� �� �߰�
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
			// �ؽ�Ʈ�ʵ忡�� ����Ű�� �Է����� ��
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
				// �ؽ�Ʈ�ʵ忡 �Է��� ������ �𵨿� �߰�(����Ʈ�� ���ŵ�)
				model.addElement(tf.getText());
				// �Է� Ŀ�� �̵�
				tf.setText("");
				tf.requestFocus();
			}
		});
		panel.add(btnAdd);

		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JList���� ���õ� �������� �ε�����
				int index = list.getSelectedIndex();
				// �ε������� �ش��ϴ� ������ ����
				if (index != -1) {
					model.remove(index);
				}else {
					JOptionPane.showMessageDialog(ListExam.this, "������ ������ �����ϼ���.");
				}
			}
		});
		panel.add(btnDelete);

		// JList�� �߰��� �� �ۼ�
		model = new DefaultListModel<>();
		model.addElement("����");
		model.addElement("�λ�");
		model.addElement("����");
		model.addElement("��õ");
		model.addElement("��õ");
		// JList�� ���� �����Ŵ
		list = new JList<String>(model);
		contentPane.add(list, BorderLayout.CENTER);
	}

}