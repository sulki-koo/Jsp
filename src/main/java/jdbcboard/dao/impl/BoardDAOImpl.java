package jdbcboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.util.MyBatisUtil;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAOImpl boardDAOImpl = new BoardDAOImpl();
	private static SqlSession session;
	private Board board;

	private BoardDAOImpl() {
	}

	public static BoardDAOImpl getBoardDAOImpl() {
		return boardDAOImpl;
	}

	@Override
	public List<Board> selectBoard() {
		List<Board> boardList = null;
		try {
			session = MyBatisUtil.openSession();
			boardList = session.selectList("Board.selectBoard", boardList);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return boardList;
	}

	@Override
	public Board getBoard(int bid) {
		try {
//			session = MyBatisUtil.openSession();
//			board = session.selectOne("Board.getBoard", bid);
			return board;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int insertBoard(Board board) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.insert("Board.insertBoard", board);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int updateBoard(Board board) {
		try {
//			session = MyBatisUtil.openSession();
//			int result = session.update("Board.updateBoard", board);
//			session.commit();
			int result=0;
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int deleteBoard(int bid) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Board.deleteBoard", bid);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

}
