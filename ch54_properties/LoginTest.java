package ch54_properties;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class LoginTest extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest frame = new LoginTest();
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
	public LoginTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(47, 30, 62, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(49, 79, 62, 18);
		contentPane.add(lblNewLabel_1);

		userid = new JTextField();
		userid.setBounds(144, 30, 187, 18);
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(144, 73, 196, 24);
		contentPane.add(pwd);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strUserid = userid.getText();
				String strPwd = String.valueOf(pwd.getPassword());
				System.out.println("아이디:" + strUserid);
				System.out.println("비밀번호:" + strPwd);

				Connection conn = null; // DB접속 객체
				PreparedStatement pstmt = null; // sql 실행객체
				ResultSet rs = null; // sql실행 결과셋을 탐색하는 객체
				try {
					FileInputStream fis = new FileInputStream(
							"C:\\Users\\sjy04\\\\eclipse-workspace\\LifeSoft\\src\\ch54_properties\\db.prop");
					Properties prop = new Properties();
					prop.load(fis); // 파일 내용을 로딩하여 prop에 저장
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					// db에 접속
					conn = DriverManager.getConnection(url, id, password);
					String sql = "select * from member where userid =? and pwd =?"; // sql명령어
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strUserid);// 1번 물음표에 아이디입력
					pstmt.setString(2, strPwd); // 2번 물음표에 비밀번호 입력
					rs = pstmt.executeQuery(); // sql실행, 결과셋을 rs에 전달
					if (rs.next()) { // 결과셋에 자료가 있으면(로그인 성공)
						lblResult.setText(rs.getString("name") + "님 환영합니다.");
					} else { // 결과셋에 자료가 없으면(로그인 실패)
						lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					try {
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(144, 140, 105, 27);
		contentPane.add(btnNewButton);

		lblResult = new JLabel("New label");
		lblResult.setBounds(47, 184, 301, 57);
		contentPane.add(lblResult);
	}
}
