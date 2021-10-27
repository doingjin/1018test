package model.member;

import java.util.List;

public interface MemberService {
	void insertM(MemberVO mvo);
	void updateM(MemberVO mvo);
	void deleteM(MemberVO mvo);
	MemberVO getM(MemberVO mvo);
	List<MemberVO> getMList();
}
