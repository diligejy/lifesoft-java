package ch52_tcpudp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GuguClient extends JFrame {

	private JPanel contentPane;
	private JComboBox cboDan;
	private JTextArea taResult;
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuguClient frame = new GuguClient();
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
	public GuguClient() {
		// 서버에 접속
		try {
			// 소켓 생성 new Socket("ip", port)
			socket = new Socket("localhost", 9999);
			// 입력스트림과 출력스트림 생성
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB2E8\uC744 \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setBounds(14, 12, 113, 18);
		contentPane.add(lblNewLabel);

		cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//ItemEvent.SELECTED 새로운 값 선택
				//ItemEvent.DESELECTED 기존 값 해제
				
				if (e.getStateChange() == ItemEvent.SELECTED) {// 값이 선택될 때
					int dan = Integer.parseInt(cboDan.getSelectedItem().toString()); // 스트링을 숫자로
					try {
						dos.writeInt(dan); // 서버에 값을 보냄
						taResult.setText(dis.readUTF());// 서버에서 보낸 결과 출력
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
				}
			}
		});
		cboDan.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9" }));
		cboDan.setBounds(141, 9, 151, 18);
		contentPane.add(cboDan);

		taResult = new JTextArea();
		taResult.setBounds(43, 42, 303, 168);
		contentPane.add(taResult);
	}
}
