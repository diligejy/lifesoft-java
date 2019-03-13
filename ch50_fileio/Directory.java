package ch50_fileio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Directory extends JFrame {

	private JPanel contentPane;
	private JTextField txtDirectory;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("디렉토리");
		panel.add(lblNewLabel);

		txtDirectory = new JTextField();
		panel.add(txtDirectory);
		txtDirectory.setColumns(10);

		JButton button1 = new JButton("확인");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드에 입력한 문자열
				String directory = txtDirectory.getText();
				// 디렉토리 정보를 가리키는 객체 생성
				File file = new File(directory);
				String[] list = file.list(); // 디렉토리의 파일 목록을 배열로 저장
				ta.setText(""); // 텍스트 에어리어 초기화
				for (int i = 0; i < list.length; i++) {
					// new File(디렉토리, 파일) 디렉토리에 속한 파일의 정보
					File f = new File(directory, list[i]);
					// isDirectory() 이면 true, 아니면 false
					String str = f.isDirectory() ? "디렉토리" : "파일";
					ta.append(str + ":" + list[i] + "\n");
				}
			}
		});
		panel.add(button1);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}

}
