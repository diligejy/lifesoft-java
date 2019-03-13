package ch52_tcpudp;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketExam {
	public static void main(String[] args) {
		ServerSocket socket = null; // 서비스 제공을 위한 소켓
		for (int i = 0; i <= 65535; i++) {
			try {
				socket = new ServerSocket(i);// 서버 소켓 생성
				socket.close(); // 소켓 닫기
			} catch (IOException e) {
				System.out.println(i + "번 포트는 사용중입니다");
			}
		}
	}
}
