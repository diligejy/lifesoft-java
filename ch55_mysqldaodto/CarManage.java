package ch55_mysqldaodto;

import java.util.List;
import java.util.Scanner;

public class CarManage {

	void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 차량번호:");
		String license_number = scan.nextLine();
		CarDAO dao = new CarDAO();
		// 삭제된 레코드 갯수가 result 변수에 리턴됨
		// 1이면 삭제 성공, 0이면 삭제 실패
		int result = dao.deleteCar(license_number);
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("차량번호를 확인하세요");
		}
	}

	void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("차량번호:");
		String license_number = scan.nextLine();
		System.out.println("제조사:");
		String company = scan.nextLine();
		System.out.println("타입:");
		String type = scan.nextLine();
		System.out.println("제조연도:");
		int year = scan.nextInt();
		System.out.println("연비:");
		int efficiency = scan.nextInt();
		CarDAO dao = new CarDAO();
		CarDTO dto = new CarDTO(license_number, company, type, year, efficiency);
		dao.insertCar(dto);
		System.out.println("추가되었습니다");
	}

	void list() {
		CarDAO dao = new CarDAO();
		List<CarDTO> items = dao.listCar();// car 테이블의 모든 레코드 리턴
		System.out.println("차량번호\t연도\t제조사\t타입\t연비");
		for (CarDTO dto : items) {
			System.out.println(dto); // CarDTO의 toString() 호출
		}
	}

	public static void main(String[] args) {
		CarManage manage = new CarManage();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("작업을 선택하세요(1.목록, 2. 추가 3. 삭제  0.종료");
			int code = scan.nextInt();
			switch (code) { // code값에 따라 분기
			case 0:
				scan.close(); // 스캐너 정리
				System.out.println("프로그램을 종료합니다");
				System.exit(0); // 프로그램 강제 종료
				break;
			case 1:
				manage.list(); // 목록 출력
				break;
			case 2:
				manage.insert();
				break;
			case 3:
				manage.delete();
				break;
			}
		}
	}

}
