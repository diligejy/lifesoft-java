package ch50_fileio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//비순차적 파일(RandomAccessFile)
public class RandomFile {
	public static void main(String[] args) throws IOException {
		StringBuilder output = new StringBuilder();
		String str = null;
		try {
			RandomAccessFile file = new RandomAccessFile("d:\\test.txt", "rw"); // 읽기+쓰기 가능한 비순차접근파일
			// 파일포인터(파일에서 읽을 위치를 가리키는 포인터)

			file.seek(18);// 파일 포인터를 이동시킴
			file.write("추가한 문자열".getBytes());// 문자열을 바이트배열로 변환한 후 파일에 저장
			while (file.getFilePointer() < file.length()) {
				// 파일 포인터 표시
				output.append(file.getFilePointer() + ":");
				str = file.readLine(); // 한 줄을 읽음
				// 한글처리
				// new String(바이트배열, 문자셋) 인코딩 변환
				str = new String(str.getBytes("8859_1"), "ms949");
				output.append(str + "\r\n"); // StringBuilder에 덧붙임
			}
			file.close(); // 파일 객체 닫음
			System.out.println(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
