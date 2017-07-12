package com.kvs.mybatis.sample.entity;


/**
 * Base class to be extended by every entity object in DB.
 * Class provides the common methods for all entity objects
 * 
 * @author kvs
 *
 */
public abstract class BaseEntity<PK> {

	/**
	 * Retrieves the primary key of the record in database
	 * @return the primary key or the unique identifier of the domain object.
	 */
	public abstract PK getPrimaryKey();

}
