package com.kvs.mybatis.sample.dao;


import com.kvs.mybatis.sample.dao.impl.DAOImpl;
import com.kvs.mybatis.sample.entity.Deal;

/**
 * Abtract class defines database access methods to deal table
 * 
 * @author kvs
 *
 */
public abstract class AbstractDealDAO extends DAOImpl<Deal, Integer>  {
	
	/**
	 * Constructs a new  AbstractDealDAO with classtype of domain object.
	 * @param type is the class type of the domain object.
	 */
	public AbstractDealDAO(Class<Deal> type) {
		super(type);
	}
	
}
