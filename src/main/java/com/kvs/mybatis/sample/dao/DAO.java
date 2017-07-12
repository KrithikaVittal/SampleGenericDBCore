package com.kvs.mybatis.sample.dao;


import java.util.List;

import com.kvs.mybatis.sample.entity.BaseEntity;

/**
 * Interface provides methods for the CRUD operation of objects in Database.
 * @author kvs
 *
 * @param <T> is the object to be manipulated for CRUD operation.
 * @param <PK> is the primary key in the db table/unique identifier of the object.
 * test
 */
public interface DAO<T extends BaseEntity<PK>, PK> {

	/**
	 * Inserts record into the db table.
	 * @param t is the object to be inserted into the db table.
	 * @return the primary key of the inserted object.
	 */
	public PK createEntity(T t);

	/**
	 * Deletes record from the db table
	 * @param id is the primary key of the record to be deleted.
	 * @return no of rows deleted.
	 */
	public Integer deleteEntity(PK id);

	/**
	 * Gets a record from the db table
	 * @param id is the primary key of the record to be retrieved.
	 * @return object of the retrieved record.
	 */
	public T findEntityById(PK id);

	/**
	 * Updates a record in the db table
	 * @param t is the object to be updated into the db table.
	 * @return no of rows updated.
	 */
	public Integer updateEntity(T t);
	
	/**
	 * Inserts record into the db table as a batch.
	 * @param list is the total no of objects to be created.
	 * @param batchSize is the size of the data to be committed to db.
	 * Specify 0 for batchsize if batch is not needed.
	 */
	public void createAllEntities(List<T> list,int batchSize);
	
	/**
	 * Selects all records from db table.
	 * @return list of all records from db table.
	 */
	public List<T> findAllEntities();
}
