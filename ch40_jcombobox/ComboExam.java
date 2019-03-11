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
//콤보박스의 값 선택
//기존값은 DESELECTED(2), 새로운 값은 SELECTED(1)
		JComboBox cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			// 콤보박스의 내용을 선택하면 자동으로 호출됨
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// 콤보박스에서 선택한 내용
					// System.out.println(cboDan.getSelectedItem());
					// 콤보박스에서 선택한 값의 인덱스
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
