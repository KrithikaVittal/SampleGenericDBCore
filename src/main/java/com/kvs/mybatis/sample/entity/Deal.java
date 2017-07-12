package com.kvs.mybatis.sample.entity;

import java.sql.Timestamp;

/**
 * Entity object that represents the DEAL table in db.
 * @author kvs
 *
 */
public class Deal extends BaseEntity<Integer>{
	
	private Integer dealID;
	
	private String dealName;
	
	private String dealDesc;
	
	private Timestamp lastUpdated;

	/**
	 * @return the dealID
	 */
	public Integer getDealID() {
		return dealID;
	}

	/**
	 * @param dealID the dealID to set
	 */
	public void setDealID(Integer dealID) {
		this.dealID = dealID;
	}

	/**
	 * @return the dealName
	 */
	public String getDealName() {
		return dealName;
	}

	/**
	 * @param dealName the dealName to set
	 */
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	/**
	 * @return the dealDesc
	 */
	public String getDealDesc() {
		return dealDesc;
	}

	/**
	 * @param dealDesc the dealDesc to set
	 */
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	/**
	 * @return the lastUpdated
	 */
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public Integer getPrimaryKey() {
		return dealID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deal [" + (dealID != null ? "dealID=" + dealID + ", " : "")
				+ (dealName != null ? "dealName=" + dealName + ", " : "")
				+ (dealDesc != null ? "dealDesc=" + dealDesc + ", " : "")
				+ (lastUpdated != null ? "lastUpdated=" + lastUpdated : "") + "]";
	}
	
	

}
