package jdbcboard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Member;
import jdbcboard.util.MyBatisUtil;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getMemberDAOImpl() {
		return memberDAOImpl;
	}

	@Override
	public List<Member> selectMember() {
		try (SqlSession session = MyBatisUtil.openSession()) {
			return session.selectList("Member.selectMember");
		}
	}

	@Override
	public Member getMember(String mid) {
		try (SqlSession session = MyBatisUtil.openSession()) {
			return session.selectOne("Member.getMember", mid);
		}
	}

	@Override
	public int insertMember(Member member) {
		try (SqlSession session = MyBatisUtil.openSession()) {
			int result = session.insert("Member.insertMember", member);
			session.commit();
			return result;
		}
	}

	@Override
	public int updateMember(Member member) {
		try (SqlSession session = MyBatisUtil.openSession()) {
			int result = session.update("Member.updateMember", member);
			session.commit();
			return result;
		}
	}

	@Override
	public int deleteMember(String mid) {
		try (SqlSession session = MyBatisUtil.openSession()) {
			int result = session.update("Member.deleteMember", mid);
			session.commit();
			return result;
		}
	}

	@Override
	public boolean checkLogin(String mid, String mpass) {
		try (SqlSession session = MyBatisUtil.openSession()) {
			Map<String, Object> loginMap = new HashMap<String, Object>();
			loginMap.put("mid", mid);
			loginMap.put("mpass", mpass);
			int result = session.selectOne("Member.checkLoginMember", loginMap);
			return result > 0;
		}
	}

}
