package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.ReplyDAO;
import jdbcboard.model.Reply;
import jdbcboard.util.MyBatisUtil;

public class ReplyDAOImpl implements ReplyDAO {

	private static ReplyDAOImpl replyDAOImpl = new ReplyDAOImpl();
	private static SqlSession session;
	private Reply reply;

	private ReplyDAOImpl() {
	}

	public static ReplyDAOImpl getReplyDAOImpl() {
		return replyDAOImpl;
	}

	@Override
	public List<Reply> selectReply() {
		List<Reply> replyList = null;
		try {
			session = MyBatisUtil.openSession();
			replyList = session.selectList("Reply.selectReply", replyList);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return replyList;
	}

	@Override
	public Reply getReply(int aid) {
		try {
			session = MyBatisUtil.openSession();
			reply = session.selectOne("Reply.getReply", aid);
			return reply;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int insertReplyr(Reply reply) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.insert("Reply.insertReply", reply);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int updateReply(Reply reply) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Reply.updateReply", reply);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int deleteReply(int rid) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Reply.deleteReply", rid);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

}
