package ch52_tcpudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null; // 서버용 소켓
		try {
			serverSocket = new ServerSocket(5555); // 5555번 포트 개방
			System.out.println("서비스가 시작되었습니다.");
		} catch (Exception e) {
			System.out.println("서비스를 시작할 수 없습니다.");
			e.printStackTrace();
		}
		Socket clientSocket = null; // 클라이언트와의 통신을 위한 소켓
		clientSocket = serverSocket.accept(); // 접속 허가 => 회선이 연결
		System.out.println("클라이언트의 ip 주소 :" + clientSocket.getInetAddress().getHostAddress());
		// 데이터 송수신을 위한 스트림 생성
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String receive = "";
		String send = "Welcome!!";

		writer.println(send); // 클라이언트에게 메시지를 보냄
		Scanner sc = new Scanner(System.in);
		while (true) {
			receive = reader.readLine(); // 클라이언트의 메시지 수신
			if (receive == null || receive.equals("quit")) {// 종료 조건
				break;
			}
			System.out.println("[클라이언트]" + receive);
			System.out.println("입력하세요(종료:quit):");
			send = sc.nextLine(); // 키보드로 한줄 입력
			writer.println(send); // 클라이언트에게 메시지를 보냄
		}
		// 리소스 정리
		sc.close();
		writer.close();
		reader.close();
		clientSocket.close();
		serverSocket.close();
	}

}
