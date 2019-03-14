package ch52_tcpudp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GuguServer implements Runnable {
	private ServerSocket serverSocket; // 서버소켓 변수
	private Socket socket; // 클라이언트와의 통신을 위한 소켓변수
	private DataInputStream dis; // 입력스트림
	private DataOutputStream dos; // 출력스트림

	public GuguServer() {
		// 생성자
		try {
			// 9999번 포트를 사용하는 서비스 소켓 생성
			serverSocket = new ServerSocket(9999);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				socket = serverSocket.accept();// 클라이언트가 접속하면 허가
				InetAddress ip = socket.getInetAddress();
				System.out.println("클라이언트의 ip주소" + ip);
				// 클라이언트와 데이터를 주고 받기 위한 스트림 생성
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				// 백그라운드 스레드 생성 및 시작 요청
				Thread th = new Thread(this);
				th.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GuguServer(); // 생성자 호출
	}

	@Override
	public void run() {
		// 백그라운드 스레드에서 실행하는 코드
		while (true) {
			try {
				int dan = dis.readInt();// 클라이언트에서 보낸 단(2~9)을 읽음
				System.out.println("클라이언트에서 요청");
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(dan + "x" + i + dan * i + "\r\n");
				}
				// 클라이언트에 결과값을 보냄
				dos.writeUTF(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
