package jdbcboard.test;

import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.service.ArticleService;
import jdbcboard.service.impl.ArticleServiceImpl;

public class ArticleServiceTest {

	public static void main(String[] args) {

		ArticleService articleService = ArticleServiceImpl.getArticleServiceImpl();

		// insert
//		Article article= new Article(0, "2번 제목", "2번 내용", 0, null, "N", 0, 0, 4, "hong3", null);
//		int result = articleService.insertArticle(article);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}

		// update
//		Article article= new Article(7, "new2번 제목", "new2번 내용", 0, null, "N", 0, 0, 4, "hong3", null);
//		int result = articleService.updateArticle(article);
//		if(result > 0) {
//			System.out.println("수정성공");
//		}

		// delelte
//		int result = articleService.deleteArticle(6);
//		if (result > 0) {
//			System.out.println("삭제성공");
//		}
		
		for(int i=1; i<101; i++) {
			Article article = new Article(0, i+"번 제목", i+"번 내용", 0, null, "N", 0, 0, 3, "hong2", null);
			int result = articleService.insertArticle(article);
			}

		// selete
//		List<Article> articleList = articleService.selectArticle();
//		for (Article article1 : articleList) {
//			System.out.println(article1);
//		}

		// get
//		Article article = articleService.getArticle(7);
//		System.out.println(article);

	}

}
