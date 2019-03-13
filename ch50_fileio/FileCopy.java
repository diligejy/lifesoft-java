package ch50_fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		String str = "";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String file1 = "d:\\a.txt"; // 원본 파일
		String file2 = "d:\\b.txt"; // 복사본
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "utf-8"));// 파일 내용 읽기용
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "utf-8")); // 파일에 쓰기용
			while (true) {
				str = reader.readLine();// 한 라인을 읽음
				if (str == null)
					break; // 더 이상 내용이 없으면 종료
				writer.write(str + "\r\n"); // 파일에 기록(줄바꿈은 수동으로 추가)
			}
			System.out.println("파일 복사가 완료되었습니다");
			// 버퍼를 닫음
			// reader.close();
			// writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}

	}
}
