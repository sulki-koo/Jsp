package jdbcboard.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static final String SQLMAPCONFIG = "jdbcboard/conf/sqlMapConfig.xml";
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader = null;

	static {
		try {
			reader = Resources.getResourceAsReader(SQLMAPCONFIG);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		return sqlSessionFactory.openSession();
	}

	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}