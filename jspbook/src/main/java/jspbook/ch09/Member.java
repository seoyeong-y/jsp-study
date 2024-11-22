package jspbook.ch09;

public class Member {

	// 회원 정보 멤버 변수
	private String name;
	private String email;

	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// 기본 생성자인 경우 다음과 같이 초기화
	public Member() {
		name = "디폴트";
		email = "default@tukorea.ac.kr";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
