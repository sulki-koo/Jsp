package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ReplyDAOImpl;
import jdbcboard.model.Reply;
import jdbcboard.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	
	private ReplyDAOImpl replyDAOImpl;

	public ReplyServiceImpl() {
		replyDAOImpl = new ReplyDAOImpl();
	}
	
	@Override
	public List<Reply> selectReply() {
		return replyDAOImpl.selectReply();
	}

	@Override
	public Reply getReply(int rid) {
		return replyDAOImpl.getReply(rid);
	}

	@Override
	public int insertReplyr(Reply reply) {
		return replyDAOImpl.insertReplyr(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		return replyDAOImpl.updateReply(reply);
	}

	@Override
	public int deleteReply(int rid) {
		return replyDAOImpl.deleteReply(rid);
	}

}
