package ch52_tcpudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		try {
			// 서버의 ip 주소 정보
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println("서버에 보낼 메시지를 입력하세요");
			Scanner scan = new Scanner(System.in);
			String data = scan.nextLine();
			byte[] send = data.getBytes(); // 스트링을 바이트배열로 변환
			// 패킷 생성 new DatagramPacket(바이트배열, 사이즈, 서버ip, 포트번호)
			DatagramPacket packet = new DatagramPacket(send, send.length, address, 7777);
			// 데이터 전달을 위한 소켓 생성
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet); // 서벙 데이터 전송
			socket.close(); // 소켓 닫기
			System.out.println("전송되었습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
