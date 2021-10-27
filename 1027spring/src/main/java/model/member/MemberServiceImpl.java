package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public void insertM(MemberVO mvo) {
		mdao.insertM(mvo);
	}

	@Override
	public void updateM(MemberVO mvo) {
		mdao.updateM(mvo);
	}

	@Override
	public void deleteM(MemberVO mvo) {
		mdao.deleteM(mvo);
	}

	@Override
	public MemberVO getM(MemberVO mvo) {
		return mdao.getM(mvo);
	}

	@Override
	public List<MemberVO> getMList() {
		return mdao.getMList();
	}

}
