package ch56_mysqlexample;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpManage {
	private EmpDAO dao;

	public EmpManage() {
		dao = new EmpDAO();
	}

	void list() {
		List<EmpDTO> items = dao.listEmp();
		System.out.println("사번\t이름\t입사일자\t급여");

		for (int i = 0; i < items.size(); i++) {
			EmpDTO dto = items.get(i);
			System.out.println(dto.getEmpno() + "\t");
			System.out.println(dto.getEname() + "\t");
			System.out.println(dto.getHiredate() + "\t");
			System.out.println(dto.getSal() + "\t");
		}
	}

	void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("사번:");
		int empno = scan.nextInt();
		System.out.println("이름:");
		String ename = scan.nextLine();
		System.out.println("입사일자:");
		String hiredate = scan.nextLine();
		System.out.println("급여:");
		int sal = scan.nextInt();
		EmpDTO dto = new EmpDTO(empno, ename, Date.valueOf(hiredate), sal);
	}

	public static void main(String[] args) {
		EmpManage emp = new EmpManage();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("메뉴를 선택하세요(1.목록, 2.추가, 3.삭제, 0:종료");
			int code = scan.nextInt();
			switch (code) {
			case 0:
				System.exit(0);
				break;
			case 1:
				emp.list();
				break;
			case 2:
				emp.insert();
				break;
			case 3:
			}
		}
	}
}
