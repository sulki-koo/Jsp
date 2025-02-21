package blog;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BlogTest {

	public static void main(String[] args) {

		// MyBatis 설정파일의 패키지 경로
		String resource = "conf/configruation.xml";
		Reader reader = null;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			// selectList()로 여러 개의 Blog를 가져올 경우
			List<Blog> blogList = session.selectList("selectBlogDetails", 1);

			for(Blog eachblog : blogList) {
				System.out.println(eachblog);
			}
			
//			session.commit(); // 커밋
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) session.close();
		}

	} // main

} // class
