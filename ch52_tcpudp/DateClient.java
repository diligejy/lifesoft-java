package ch52_tcpudp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) throws Exception {
		// new Socket(서버IP, 포트번호) 서버에 접속
		// 서버에서 accept() 하면 통신이 가능한 상태가 됨
		Socket s = new Socket("localhost", 9100);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
		// 서버에서 보낸 메시지를 읽음
		String res = input.readLine();
		System.out.println(res);
		s.close(); // 소켓 닫기(서버와의 접속이 끊어짐)
		System.exit(0); // 프로그램 종료
	}
}
