package ch50_fileio;

import java.io.Serializable;

public class MemberInfoDTO implements Serializable {
	private String juminNo;
	private String passwd;

	public String getJuminNo() {
		return juminNo;
	}

	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public MemberInfoDTO(String juminNo, String passwd) {
		super();
		this.juminNo = juminNo;
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "MemberInfoDTO [juminNo=" + juminNo + ", passwd=" + passwd + "]";
	}

}
