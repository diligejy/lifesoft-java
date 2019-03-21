package ch56_mysqlexample;

import java.sql.Date;

public class EmpDTO {
	// EMP 테이블의 레코드 1건을 저장하는 모델 클래스
//dto : Data Transfer Object : 데이터 저장, 전달하는 객체
	private int empno;
	private String ename;
	private Date hiredate;
	private int sal;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal + "]";
	}

	public EmpDTO(int empno, String ename, Date hiredate, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}

	public EmpDTO() {
		super();
	}

}
