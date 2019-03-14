package ch52_tcpudp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//GUI 화면 표시 크래스

class ServerScreen extends JFrame {
	JTextArea ta;
	JTextField tf;

	public ServerScreen() {
		setSize(300, 300); // 화면 사이즈
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 닫기 버튼 설정
		setTitle("채팅방 서버"); // 프레임의 제목

		JLabel label = new JLabel("This is a server!");
		ta = new JTextArea(25, 40); // 25행 40열의 텍스트 입력 상자
		tf = new JTextField(25); // 25컬럼
		// 프레임에 붙임
		add(label, "North");
		add(ta, "Center");
		add(tf, "South");
		setVisible(true);// 프레임을 화면에 표시
	}
}

public class MultiChatServer {

	HashMap userMap;

	public MultiChatServer() {
		userMap = new HashMap(); // 해시맵 생성
		Collections.synchronizedMap(userMap); // 해시맵 동기화
	}

	void serviceStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			// 서비스 제공을 위한 서버소켓 생성, 포트번호 7777
			serverSocket = new ServerSocket(7777);
			System.out.println("서비스가 시작되었습니다");
			while (true) {
				// 클라이언트의 접속을 기다리다가 접속하면 접속을 허가함(통신용 소켓이 생성됨)
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + "]에서 접속하셨습니다");
				// 클라이언트별로 메시지 수신을 위한 스레드가 생성됨
				// 10명이 접속하면 10개의 스레드가 생성됨 (속도가 느려짐)
				ServerReceiver receiveThread = new ServerReceiver(socket);
				receiveThread.start();
				System.out.println("현재 실행중인 스레드 이름 :" + receiveThread.getName());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 현재 접속중인 모든 사용자에게 메시지 전송
	void sendToAll(String msg) {
		// 해시맵에서 Key값들의 집합을 리턴받음
		Iterator it = userMap.keySet().iterator();
		while (it.hasNext()) {// 다음 키 값이 있으면
			try {
				DataOutputStream out = (DataOutputStream) userMap.get(it.next());
				out.writeUTF(msg);// 메시지 전송
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 화면 구성 클래스 실행
		new ServerScreen();
		// 채팅 서비스 시작
		new MultiChatServer().serviceStart();
	}

	// 메시지 수신 클래스(내부 클래스)
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 사용자별로 생성되는 백그라운드 스레드가 실행하는 코드
		@Override
		public void run() {
			String name = "";
			try {
				name = in.readUTF(); // 메시지 수신
				sendToAll("#" + name + "님이 들어오셨습니다."); // 메시지 보내기
				userMap.put(name, out); // 해시맵에 사용자 추가
				System.out.println("현재 접속자 수 :" + userMap.size());
				while (in != null) {
					// 받은 메시지를 모든 사용자에게 보냄
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 대화방을 나간 사용자의 정보 출력
				sendToAll("#" + name + "님이 나가셨습니다.");
				userMap.remove(name); // 해시맵에서 제거
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]에서 접속을 종료함");
				System.out.println("현재 접속자 수 :" + userMap.size());

			}

		}
	}
}
