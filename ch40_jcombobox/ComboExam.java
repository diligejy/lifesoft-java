package ch40_jcombobox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ComboExam extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboExam frame = new ComboExam();
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
	public ComboExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
//�޺��ڽ��� �� ����
//�������� DESELECTED(2), ���ο� ���� SELECTED(1)
		JComboBox cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			// �޺��ڽ��� ������ �����ϸ� �ڵ����� ȣ���
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// �޺��ڽ����� ������ ����
					// System.out.println(cboDan.getSelectedItem());
					// �޺��ڽ����� ������ ���� �ε���
					// System.out.println(cboDan.getSelectedIndex());
					int dan = Integer.parseInt((String) cboDan.getSelectedItem());
					ta.setText("");
					for (int i = 1; i <= 9; i++) {
						ta.append(String.format("%d x %d = %2d\n", dan, i, dan*i));
					}
				}
			}
		});
		cboDan.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }));
		contentPane.add(cboDan, BorderLayout.NORTH);

		ta = new JTextArea();
		contentPane.add(ta, BorderLayout.CENTER);
	}

}
