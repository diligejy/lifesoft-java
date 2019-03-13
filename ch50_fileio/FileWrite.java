package ch50_fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream("d:\\test.txt");
			System.out.println("입력하세요:");
			while (true) {
				int ch = System.in.read();
				if (ch == 13)
					break;
				os.write(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
