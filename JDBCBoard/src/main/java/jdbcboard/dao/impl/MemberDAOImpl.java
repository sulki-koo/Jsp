package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.MemberDAO;
import jdbcboard.model.Member;
import jdbcboard.util.ConnectionUtil;

public class MemberDAOImpl implements MemberDAO {

	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

	private MemberDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static MemberDAOImpl getMemberDAOImpl() {
		return memberDAOImpl;
	}

	@Override
	public List<Member> selectMember() {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("SELECT_MEMBER"));
			rs = pstmt.executeQuery();

			List<Member> MemberList = new ArrayList<Member>();
			if (rs != null) {
				while (rs.next()) {
					Member member = new Member();
					member.setMid(rs.getString("mid"));
					member.setMname(rs.getString("mname"));
					member.setMalias(rs.getString("malias"));
					member.setMpass(rs.getString("mpass"));
					member.setMemail(rs.getString("memail"));
					member.setMcp(rs.getString("mcp"));
					member.setMdelyn(rs.getString("mdelyn"));
					MemberList.add(member);
				}
			}
			return MemberList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public Member getMember(String mid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("GET_MEMBER"));
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMalias(rs.getString("malias"));
				member.setMpass(rs.getString("mpass"));
				member.setMemail(rs.getString("memail"));
				member.setMcp(rs.getString("mcp"));
				member.setMdelyn(rs.getString("mdelyn"));
				return member;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public int insertMember(Member member) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("INSERT_MEMBER"));
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMalias());
			pstmt.setString(4, member.getMpass());
			pstmt.setString(5, member.getMemail());
			pstmt.setString(6, member.getMcp());
			pstmt.setString(7, "N");
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public int updateMember(Member member) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("UPDATE_MEMBER"));
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMalias());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMcp());
			pstmt.setString(5, member.getMid());
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public int deleteMember(String mid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("DELETE_MEMBER"));
			pstmt.setString(1, mid);
			return pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	@Override
	public boolean checkLogin(String mid, String mpass) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("CHECKLOGIN_MEMBER"));
			pstmt.setString(1, mid);
			pstmt.setString(2, mpass);
			rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt("cnt")>0) return true;
			else return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionUtil.getConnectionUtil().closeConnection(rs, pstmt, conn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
