package jdbcboard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jdbcboard.dao.ArticleDAO;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.util.MyBatisUtil;

public class ArticleDAOImpl implements ArticleDAO {

	private static ArticleDAOImpl articleDAOImpl = new ArticleDAOImpl();
	private static SqlSession session;
	private Article article;

	private ArticleDAOImpl() {
	}

	public static ArticleDAOImpl getarticleDAOImpl() {
		return articleDAOImpl;
	}

	@Override
	public List<Article> selectArticle(ArticleCriteria articleCriteria) {
		List<Article> articleList = null;
		try {
			session = MyBatisUtil.openSession();
			articleList = session.selectList("Article.selectArticle", articleCriteria);
		} finally {
			MyBatisUtil.closeSession(session);
		}
		return articleList;
	}

	@Override
	public Article getArticle(int aid) {
		try {
			session = MyBatisUtil.openSession();
			article = session.selectOne("Article.getArticle", aid);
			return article;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int insertArticle(Article article) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.insert("Article.insertArticle", article);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int updateArticle(Article article) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Article.updateArticle", article);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int deleteArticle(int aid) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Article.deleteArticle", aid);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	@Override
	public int increaseAvcnt(int aid) {
		try {
			session = MyBatisUtil.openSession();
			int result = session.update("Article.increaseAvcnt", aid);
			session.commit();
			return result;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

}
