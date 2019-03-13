package ch50_fileio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStream {
	public static void main(String[] args) {
		try {
			// 이진파일(binary file)로 저장
			DataOutputStream dataout = new DataOutputStream(new FileOutputStream("d:\\test.dat"));
			dataout.writeInt(1234);
			dataout.writeChar('A');
			dataout.writeDouble(3.5);
			dataout.close(); // 닫지 않으면 파일이 완성되지 않음
			System.out.println("저장되었습니다.");
			// 이진파일을 읽기 위한 객체
			DataInputStream datain = new DataInputStream(new FileInputStream("d:\\test.dat"));
			System.out.println(datain.readInt());
			System.out.println(datain.readChar());
			System.out.println(datain.readDouble());
			System.out.println(datain.readUTF());
			System.out.println(datain.readBoolean());
			datain.close();
		} catch (Exception e) {
		}
	}
}
