package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.BoardDAO;
import jdbcboard.model.Board;
import jdbcboard.util.ConnectionUtil;

public class BoardDAOImpl implements BoardDAO {
	
	Connection conn = null;
	Properties sqlProperties = null;	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static BoardDAOImpl boardDAOImpl = new BoardDAOImpl();
	
	private BoardDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static BoardDAOImpl getBoardDAOImpl() {
		return boardDAOImpl;
	}
	
	@Override
	public List<Board> selectBoard() {
		try {
			String sql = sqlProperties.getProperty("SELECT_BOARD");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Board> boardList = new ArrayList<Board>();
			while (rs.next()) {
				Board board = new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBacnt(rs.getInt("bacnt"));
				boardList.add(board);
			}
			return boardList;
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
	public Board getBoard(int bid) {
		try {
			String sql = sqlProperties.getProperty("GET_BOARD");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			Board board = null;
			if (rs.next()) {
				board = new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBacnt(rs.getInt("bacnt"));
			}
			return board;
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
	public int insertBoard(Board board) {
		try {
			String sql = sqlProperties.getProperty("INSERT_BOARD");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setInt(2, board.getBacnt());
			int result = pstmt.executeUpdate();
			return result;
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
	public int updateBoard(Board board) {
		try {
			String sql = sqlProperties.getProperty("UPDATE_BOARD");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBname());
			pstmt.setInt(2, board.getBid());
			int result = pstmt.executeUpdate();
			return result;
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
	public int deleteBoard(int bid) {
		try {
			String sql = sqlProperties.getProperty("DELETE_BOARD");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			int result = pstmt.executeUpdate();
			return result;
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
















