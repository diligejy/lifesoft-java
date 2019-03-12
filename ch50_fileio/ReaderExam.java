package ch50_fileio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderExam {
	public static void main(String[] args) {
		int var = 0;
		Reader input = new InputStreamReader(System.in);
		System.out.println("입력하세요");
		// new InputStreamReader(InputStream 객체)
		while (true) {
			try {
				var = input.read(); // 2바이트 단위로 읽음
				System.out.println((char)var + "==>" + var);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (var == 13)
				break; // 엔터키를 입력했으면 반복문을 종료시킴
		}
	}
}
