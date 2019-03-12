package ch50_fileio;

import java.io.IOException;

public class InputStreamExam {
	public static void main(String[] args) {
		// System.in ==> InputStream(1바이트 단위 입력)
		int var = 0;
		System.out.println("내용을 입력하세요");
		try {
			var = System.in.read(); // 키보드로 1byte를 입력받음
			while(var != 13) {// 13번 ==> 엔터문자
				System.out.println((char)var);
				var = System.in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.printf("입력한 문자 : %c 문자코드:%d", var, var);
		//var = '가';
		//System.out.printf("입력한 문자 : %c 문자코드 : %d", var, var);
	}
}
