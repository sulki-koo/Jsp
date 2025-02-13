package jdbcboard.dao.impl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

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
			sqlProperties.load(new FileReader("D:/embededk/jee_workspace/JDBCBoard/src/main/webapp/WEB-INF/props/sql.properties"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Article> selectArticle() {
		
		
		return ArticleDAO.super.selectArticle();
	}

	@Override
	public Article getArticle(int aid) {
		
		
		return ArticleDAO.super.getArticle(aid);
	}

	@Override
	public int insertArticle(Article article) {
		
		
		return ArticleDAO.super.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
		
		
		return ArticleDAO.super.updateArticle(article);
	}

	@Override
	public int deleteArticle(int aid) {
		
		
		return ArticleDAO.super.deleteArticle(aid);
	}

}
