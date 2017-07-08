package com.kvs.mybatis.sample.persistence;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * SqlSessionUtils provides the session for DAO methods.
 * @author kvs
 *
 */
public class SqlSessionUtils {
	
	private static Logger log = Logger.getLogger(SqlSessionUtils.class);

	private static SqlSessionFactory sqlSessionFactory;
	
	/*
	 * One time Loading of the mybatis configuration file.
	 */
	static
	{
		log.info("Loading the mybatis config and creating sql session factory");
		String resource = "config/mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
			if (null == sqlSessionFactory) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			System.exit(1);
		}		
	}
	
	private SqlSessionUtils() {
	}

	/**
	 * Opens a database session
	 * @return SqlSession to be used for db operations
	 */
	public static SqlSession getSession(){		
		return sqlSessionFactory.openSession();
	}
	
	/**
	 * Closes a database session
	 * @param sqlSession to be closed.
	 */
	public static void closeSession(SqlSession sqlSession){		
		sqlSession.close();
	}
	
	/**
	 * Opens a database session for batch execution
	 * @param batchMode set to true for batch operation
	 * @return sqlSession for batch operation
	 */
	public static SqlSession getSqlSession(Boolean batchMode) {
		
		if (batchMode) {
			return sqlSessionFactory.openSession(ExecutorType.BATCH);
		}
		
		return sqlSessionFactory.openSession();
	}
}
