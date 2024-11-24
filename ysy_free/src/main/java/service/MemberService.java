package service;

import java.util.ArrayList;

import domain.MemberVO;
import persistence.MemberDAO;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService() {
		memberDAO = new MemberDAO(); // MemberDAO 객체 생성
	}

	// 회원 로그인 처리
	public MemberVO login(String id, String passwd) {
		return memberDAO.read(id, passwd); // DAO의 read 메서드를 호출하여 회원 정보 조회
	}

	// 회원 가입 처리
	public boolean registerMember(MemberVO member) {
		return memberDAO.add(member); // DAO의 add 메서드를 호출하여 회원 등록
	}

	// 회원 정보 수정 처리
	public boolean updateMember(MemberVO member) {
		return memberDAO.update(member); // DAO의 update 메서드를 호출하여 회원 정보 수정
	}

	// 회원 목록 조회
	public ArrayList<MemberVO> getMemberList() {
		return memberDAO.getMemberList(); // DAO의 getMemberList 메서드를 호출하여 회원 목록 조회
	}

	// 특정 ID와 비밀번호로 회원 조회
	public MemberVO getMemberById(String id, String passwd) {
		return memberDAO.read(id, passwd); // DAO의 read 메서드를 호출하여 해당 ID와 비밀번호를 가진 회원 정보 조회
	}

	// 회원 존재 여부 확인
	public boolean isMemberExist(String id) {
		return memberDAO.read(id, null) != null; // ID로 회원 존재 여부 확인
	}
}
