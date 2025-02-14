package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.util.ConnectionUtil;
import oracle.net.aso.r;

public class ReplyDAOImpl implements ReplyDAO {

	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ReplyDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Reply> selectReply() {
		try {
			String sql = sqlProperties.getProperty("SELECT_REPLY");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Reply> replyList = new ArrayList<Reply>();
			if (rs != null) {
				while (rs.next()) {
					Reply reply = new Reply();
					reply.setRid(rs.getInt("rid"));
					reply.setRcontent(rs.getString("rcontent"));
					reply.setRregdate(rs.getTimestamp("rregdate"));
					reply.setRdelyn(rs.getString("rdelyn"));
					reply.setMid(rs.getString("mid"));
					reply.setAid(rs.getInt("aid"));
					replyList.add(reply);
				}
			}
			return replyList;
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
	public Reply getReply(int rid) {
		try {
			String sql = sqlProperties.getProperty("GET_REPLY");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
			rs = pstmt.executeQuery();
			Reply reply = null;
			if (rs != null && rs.next()) {
				reply = new Reply();
				reply.setRid(rs.getInt("rid"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRregdate(rs.getTimestamp("rregdate"));
				reply.setRdelyn(rs.getString("rdelyn"));
				reply.setMid(rs.getString("mid"));
				reply.setAid(rs.getInt("aid"));
			}
			return reply;
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
	public int insertReplyr(Reply reply) {
		try {
			String sql = sqlProperties.getProperty("INSERT_REPLY");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getRcontent());
			pstmt.setString(2, "N");
			pstmt.setString(3, reply.getMid());
			pstmt.setInt(4, reply.getAid());
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
	public int updateReply(Reply reply) {
		try {
			String sql = sqlProperties.getProperty("UPDATE_REPLY");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply.getRcontent());
			pstmt.setInt(2, reply.getRid());
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
	public int deleteReply(int rid) {
		try {
			String sql = sqlProperties.getProperty("DELETE_REPLY");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rid);
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

}
