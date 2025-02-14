package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbcboard.constant.ApplicationConstant;
import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.util.ConnectionUtil;

public class ArticleDAOImpl implements ArticleDAO {

	Connection conn = null;
	Properties sqlProperties = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArticleDAOImpl() {
		try {
			sqlProperties = new Properties();
			sqlProperties.load(new FileReader(ApplicationConstant.SQL_PROPERTIES));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Article> selectArticle() {
		try {
			String sql = sqlProperties.getProperty("SELECT_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Article> articleList = new ArrayList<Article>();

			if (rs != null) {
				while (rs.next()) {
					Article article = new Article();
					article.setAid(rs.getInt("aid"));
					article.setAsubject(rs.getString("asubject"));
					article.setAcontent(rs.getString("acontent"));
					article.setAvcnt(rs.getInt("avcnt"));
					article.setAregdate(rs.getTimestamp("aregdate"));
					article.setAdelyn(rs.getString("adelyn"));
					article.setAafcnt(rs.getInt("aafcnt"));
					article.setArcnt(rs.getInt("arcnt"));
					article.setBid(rs.getInt("bid"));
					article.setMid(rs.getString("mid"));
					articleList.add(article);
				}
				return articleList;
			}
			return articleList;
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
	public Article getArticle(int aid) {
		try {
			String sql = sqlProperties.getProperty("GET_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			rs = pstmt.executeQuery();

			Article article = null;
			if (rs != null && rs.next()) {
				article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAsubject(rs.getString("asubject"));
				article.setAcontent(rs.getString("acontent"));
				article.setAvcnt(rs.getInt("avcnt"));
				article.setAregdate(rs.getTimestamp("aregdate"));
				article.setAdelyn(rs.getString("adelyn"));
				article.setAafcnt(rs.getInt("aafcnt"));
				article.setArcnt(rs.getInt("arcnt"));
				article.setBid(rs.getInt("bid"));
				article.setMid(rs.getString("mid"));
			}
			return article;
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
	public int insertArticle(Article article) {
		try {
			String sql = sqlProperties.getProperty("INSERT_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAvcnt());
			pstmt.setString(4, "N");
			pstmt.setInt(5, article.getAafcnt());
			pstmt.setInt(6, article.getArcnt());
			pstmt.setInt(7, article.getBid());
			pstmt.setString(8, article.getMid());
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
	public int updateArticle(Article article) {
		try {
			String sql = sqlProperties.getProperty("UPDATE_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAsubject());
			pstmt.setString(2, article.getAcontent());
			pstmt.setInt(3, article.getAid());
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
	public int deleteArticle(int aid) {
		try {
			String sql = sqlProperties.getProperty("DELETE_ARTICLE");
			conn = ConnectionUtil.getConnectionUtil().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
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
