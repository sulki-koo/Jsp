package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.MemberDAOImpl;
import jdbcboard.model.Member;
import jdbcboard.service.MemberService;

public class MemberServiecImpl implements MemberService {
	
	private MemberDAOImpl memberDAOImpl;
	
	public MemberServiecImpl() {
		memberDAOImpl = new MemberDAOImpl();
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

}
