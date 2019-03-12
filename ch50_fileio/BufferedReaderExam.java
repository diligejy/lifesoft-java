package ch50_fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExam {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// new BufferedReader (InputStreamReader (InputStream))

		System.out.println("입력하세요");
		try {
			String str = reader.readLine();
			System.out.println(str); // 라인단위로 읽음
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
