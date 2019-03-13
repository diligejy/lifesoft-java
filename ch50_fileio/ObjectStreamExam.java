package ch50_fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExam {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		MemberDTO m1 = new MemberDTO("kim", 30, "871231-1234567", "1234");
		MemberDTO m2 = new MemberDTO("park", 28, "891231-1234567", "2222");
		MemberDTO m3 = new MemberDTO("hong", 25, "921231-1234567", "3322");

		try {
			fos = new FileOutputStream("d:\\object.data");
			oos = new ObjectOutputStream(fos); // 객체 직렬화 처리 객체
			oos.writeObject(m1); // 객체를 파일로 저장
			oos.writeObject(m2);
			oos.writeObject(m3);
			System.out.println("객체를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 역직렬화(파일에 저장된 객체를 다시 메모리로 불러옴)
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("d:\\object.dat");
			ois = new ObjectInputStream(fis);
			MemberDTO dto1 = (MemberDTO) ois.readObject(); // 객체 로딩
			MemberDTO dto2 = (MemberDTO) ois.readObject();
			MemberDTO dto3 = (MemberDTO) ois.readObject();
			System.out.println(dto1);
			System.out.println(dto2);
			System.out.println(dto3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
