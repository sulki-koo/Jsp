package jdbcboard.service.impl;

import java.util.List;

import jdbcboard.dao.impl.ArticleDAOImpl;
import jdbcboard.model.Article;
import jdbcboard.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDAOImpl articleDAOImpl;
	
	public ArticleServiceImpl() {
		articleDAOImpl = new ArticleDAOImpl();
	}

	@Override
	public List<Article> selectArticle() {
		return articleDAOImpl.selectArticle();
	}

	@Override
	public Article getArticle(int aid) {
		return articleDAOImpl.getArticle(aid);
	}

	@Override
	public int insertArticle(Article article) {
		return articleDAOImpl.insertArticle(article);
	}

	@Override
	public int updateArticle(Article article) {
		return articleDAOImpl.updateArticle(article);
	}

	@Override
	public int deleteArticle(int aid) {
		return articleDAOImpl.deleteArticle(aid);
	}
	
}
