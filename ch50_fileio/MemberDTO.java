package ch50_fileio;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private String name;
	private int age;
	private MemberInfoDTO memberInfo;

	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MemberDTO(String name, int age, String jumin, String pwd) {
		super();
		this.name = name;
		this.age = age;
		this.memberInfo = new MemberInfoDTO(jumin, pwd);
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + ", memberInfo=" + memberInfo + "]";
	}

}
