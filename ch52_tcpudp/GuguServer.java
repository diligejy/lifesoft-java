package ch52_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GuguServer implements Runnable {
	private ServerSocket serverSocket; // �������� ����
	private Socket socket; // Ŭ���̾�Ʈ���� ����� ���� ���Ϻ���
	private DataInputStream dis; // �Է½�Ʈ��
	private DataOutputStream dos; // ��½�Ʈ��

	public GuguServer() {
		// ������
		try {
			// 9999�� ��Ʈ�� ����ϴ� ���� ���� ����
			serverSocket = new ServerSocket(9999);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				socket = serverSocket.accept();// Ŭ���̾�Ʈ�� �����ϸ� �㰡
				InetAddress ip = socket.getInetAddress();
				System.out.println("Ŭ���̾�Ʈ�� ip�ּ�" + ip);
				// Ŭ���̾�Ʈ�� �����͸� �ְ� �ޱ� ���� ��Ʈ�� ����
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				// ��׶��� ������ ���� �� ���� ��û
				Thread th = new Thread(this);
				th.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new GuguServer(); // ������ ȣ��
	}

	@Override
	public void run() {
		// ��׶��� �����忡�� �����ϴ� �ڵ�
		while (true) {
			try {
				int dan = dis.readInt();// Ŭ���̾�Ʈ���� ���� ��(2~9)�� ����
				System.out.println("Ŭ���̾�Ʈ���� ��û");
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(dan + "x" + i + dan * i + "\r\n");
				}
				// Ŭ���̾�Ʈ�� ������� ����
				dos.writeUTF(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
