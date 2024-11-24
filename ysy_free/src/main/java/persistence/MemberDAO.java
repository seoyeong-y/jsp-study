package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

	// 데이터베이스 연결 메소드
	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook", "passwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 연결 종료 메소드
	private void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 회원가입 처리: 새로운 회원 정보 추가
	public boolean add(MemberVO vo) {
		connect();
		String sql = "insert into members (id, passwd, username, age, sex, phone) values (?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getAge());
			pstmt.setString(5, vo.getSex());
			pstmt.setString(6, vo.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	// 로그인 처리: ID와 비밀번호로 사용자 정보 조회
	public MemberVO read(String id, String passwd) {
		connect();
		String sql = "select * from members where id = ? and passwd = ?";
		MemberVO member = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setUsername(rs.getString("username"));
				member.setAge(rs.getString("age"));
				member.setSex(rs.getString("sex"));
				member.setPhone(rs.getString("phone"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
		return member;
	}

	// 회원 정보 수정
	public boolean update(MemberVO member) {
		connect();
		String sql = "update members set passwd = ?, username = ?, age = ?, sex = ?, phone = ? where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getUsername());
			pstmt.setString(3, member.getAge());
			pstmt.setString(4, member.getSex());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	// 전체 회원 목록 조회
	public ArrayList<MemberVO> getMemberList() {
		connect();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "select * from members";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setUsername(rs.getString("username"));
				member.setAge(rs.getString("age"));
				member.setSex(rs.getString("sex"));
				member.setPhone(rs.getString("phone"));
				memberList.add(member);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return memberList;
	}
}
