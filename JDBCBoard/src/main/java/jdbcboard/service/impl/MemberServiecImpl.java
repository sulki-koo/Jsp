package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.MemberDAOImpl;
import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

public class MemberServiecImpl implements MemberService {
	
	private static MemberServiecImpl memberServiceImpl = new MemberServiecImpl();
	private static MemberDAOImpl memberDAOImpl;
	
	private MemberServiecImpl() {
		memberDAOImpl = MemberDAOImpl.getMemberDAOImpl();
	}
	
	public static MemberServiecImpl getMemberServiecImpl() {
		return memberServiceImpl;
	}

	@Override
	public List<Member> selectMember() {
		return memberDAOImpl .selectMember();
	}

	@Override
	public Member getMember(String mid) {
		return memberDAOImpl.getMember(mid);
	}

	@Override
	public int insertMember(Member member) {
		return memberDAOImpl.insertMember(member);
	}

	@Override
	public int updateMember(Member member) {
		return memberDAOImpl.updateMember(member);
	}

	@Override
	public int deleteMember(String mid) {
		return memberDAOImpl.deleteMember(mid);
	}
	
	@Override
	public boolean checkLogin(String mid, String mpass) {
		return memberDAOImpl.checkLogin(mid, mpass);
	}

}
