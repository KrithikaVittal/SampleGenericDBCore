package com.kvs.mybatis.sample.entity.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kvs.mybatis.sample.dao.DAO;
import com.kvs.mybatis.sample.entity.BaseEntity;
import com.kvs.mybatis.sample.persistence.SqlSessionUtils;

/**
 * Interface implementation provides methods for the CRUD operation of deal
 * objects in Database.
 * 
 * @author kvs
 *
 * @param <T>
 *            is the object to be manipulated for CRUD operation.
 * @param <PK>
 *            is the primary key in the db table/unique identifier of the
 *            object.
 */
public abstract class DAOImpl<T extends BaseEntity<PK>, PK> implements DAO<T, PK> {

	private Class<T> type;

	/**
	 * Constructs new instance of DAOImpl
	 */
	public DAOImpl() {
	}

	/**
	 * Constructs new instance of DAOImpl with class type of domain object
	 * @param type of the object to be mapped to db
	 */
	public DAOImpl(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	public PK createEntity(T t) {

		SqlSession session = SqlSessionUtils.getSession();
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "insert" + this.type.getSimpleName();
			session.insert(query, t);
			return t.getPrimaryKey();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public Integer deleteEntity(PK id) {
		SqlSession session = SqlSessionUtils.getSession();
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "delete" + this.type.getSimpleName();
			return session.delete(query, id);
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public T findEntityById(PK id) {
		SqlSession session = SqlSessionUtils.getSession();
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "select" + this.type.getSimpleName();
			T t = session.selectOne(query, id);
			return t;
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Integer updateEntity(T t) {
		SqlSession session = SqlSessionUtils.getSession();
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "update" + this.type.getSimpleName();
			return session.update(query, t);
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public void createAllEntities(List<T> list, int batchSize) {
		SqlSession session = SqlSessionUtils.getSqlSession(true);
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "insertAll" + this.type.getSimpleName();// +"Batch";

			int size = list.size();
			for (int i = 0; i < size; i++) {
				session.insert(query, list.get(i));
				if ((batchSize != 0 && i != 0) && ((i % batchSize == 0) || (i == size - 1))) {
					session.flushStatements();
					session.clearCache();
				}
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	
	
	@Override
	public List<T> findAllEntities() {
		SqlSession session = SqlSessionUtils.getSession();
		try {
			String query = this.type.getSimpleName() + "Mapper" + "." + "selectAll" + this.type.getSimpleName();
			List<T> tList = session.selectList(query);
			return tList;
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}
}