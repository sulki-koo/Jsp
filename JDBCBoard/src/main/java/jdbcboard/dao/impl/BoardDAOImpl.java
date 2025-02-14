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

	public BoardDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Board> selectBoard() {

		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("SELECT_BOARD"));
			rs = pstmt.executeQuery();
			List<Board> boardList = new ArrayList<Board>();
			if (rs != null) {
				while (rs.next()) {
					Board board = new Board();
					board.setBid(rs.getInt("bid"));
					board.setBname(rs.getString("bname"));
					board.setBacnt(rs.getInt("bacnt"));
					boardList.add(board);
				}
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
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("GET_BOARD"));
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			Board board = null;

			if (rs != null && rs.next()) {
				board = new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				board.setBacnt(rs.getInt("bacnt"));
				return board;
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
	public int insertBoard(Board board) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("INSERT_BOARD"));
			pstmt.setString(1, board.getBname());
			pstmt.setInt(2, board.getBacnt());
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
	public int updateBoard(Board board) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("UPDATE_BOARD"));
			pstmt.setString(1, board.getBname());
			pstmt.setInt(2, board.getBacnt());
			pstmt.setInt(3, board.getBid());
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
	public int deleteBoard(int bid) {
		try {
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sqlProperties.getProperty("DELETE_BOARD"));
			pstmt.setInt(1, bid);
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
