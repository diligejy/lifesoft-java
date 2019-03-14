package ch52_tcpudp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//GUI 멀티채팅(클라이언트용 프로그램)
public class MultiChatClient {
	static String nickName = null; // 대화명
	static JTextArea ta;
	static JTextField tf;
	static DataOutputStream out;
	static DataInputStream in;

	// 메시지를 보내기 위한 스레드
	static class ClientSender extends Thread {
		Socket socket;
		String name;

		@Override
		public void run() {
			// Scanner scanner = new Scanner(System.in);
			try {
				if (out != null) {
					out.writeUTF(name); // 대화명을 보냄
				} // while(out != null){
					// out.writeUTF("["+name+"]"+scanner.nextLine());
					// }
			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		public ClientSender(Socket socket, String nickName) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = nickName;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		nickName = JOptionPane.showInputDialog("대화명을 입력하세요");
		new ClientScreen(nickName); // 클라이언트 화면 구성
		Socket socket;
		try {
			String serverIp = "127.0.0.1";
			// 서버 ip주소, 포트번호로 접속
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			// 메시지 수신용 스레드
			Thread receiveThread = new ClientReceiver(socket);
			receiveThread.start();
			// 메시지 발신용 스레드
			Thread sender = new ClientSender(socket, nickName);
			sender.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}