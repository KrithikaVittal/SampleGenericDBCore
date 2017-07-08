package com.kvs.mybatis.sample.dao;


import com.kvs.mybatis.sample.entity.Deal;

/**
 * Provides database access methods to deal table
 * 
 * @author kvs
 *
 */
public class DealDAO extends AbstractDealDAO {

	/**
	 * Constructs a new DealDAO with classtype of domain object.
	 * 
	 * @param type
	 *            is the class type of the domain object.
	 */
	public DealDAO(Class<Deal> type) {
		super(type);
	}


}
