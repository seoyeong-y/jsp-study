package domain;

public class MemberVO {
	private String id; // 아이디
	private String passwd; // 비밀번호
	private String username; // 이름
	private String age; // 나이
	private String sex; // 성별
	private String phone; // 전화번호

	// 기본 생성자
	public MemberVO() {
	}

	// 생성자
	public MemberVO(String id, String passwd, String username, String age, String sex, String phone) {
		this.id = id;
		this.passwd = passwd;
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}

	// Getter & Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
