package com.personal.mybatis.sample;



import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import com.kvs.mybatis.sample.dao.DAO;
import com.kvs.mybatis.sample.dao.DealDAO;
import com.kvs.mybatis.sample.entity.Deal;

import junit.framework.TestCase;

public class DealDAOTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCreateDeal() {

		DAO<Deal, Integer> dao = new DealDAO(Deal.class);

		Deal deal = new Deal();
		deal.setDealName("test");
		deal.setDealDesc("test");
		deal.setLastUpdated(new Timestamp(new Date().getTime()));

		Integer dealId = dao.createEntity(deal);
		assertNotNull(dealId);

	}
	
	@Test
	public void testCreateDealsAsBatch() {

		DAO<Deal, Integer> dao = new DealDAO(Deal.class);
		List<Deal> dealList=new ArrayList<Deal>();
		for(int i=0;i<100000;i++){
			Deal deal = new Deal();
			deal.setDealName("deal name"+i);
			deal.setDealDesc("deal desc"+i);
			deal.setLastUpdated(new Timestamp(new Date().getTime()));
			dealList.add(deal);
		}
		
		
		
		Instant start = Instant.now();		
		dao.createAllEntities(dealList, 0);
		
		Instant end = Instant.now();	
		Duration timeTaken=Duration.between(start, end);
		System.out.println("Time taken for mybatis batch Insert:"+timeTaken); // prints PT1M3.553S
		
		assertTrue("Time taken for mybatis batch Insert is less than 10 second ", Long.parseLong("2") > (timeTaken.getSeconds()));

	}
	
	@Test
	public void testUpdateDeal() {

		DAO<Deal, Integer> dao = new DealDAO(Deal.class);

		Deal deal = new Deal();
		deal.setDealID(100004);
		deal.setDealName("test123");
		deal.setDealDesc("test");
		deal.setLastUpdated(new Timestamp(new Date().getTime()));

		int rowsUpdated= dao.updateEntity(deal);
		
		assertNotSame(0, rowsUpdated);

	}
	
	@Test
	public void testDeleteDeal() {
		
		DAO<Deal, Integer> dao = new DealDAO(Deal.class);

		Deal deal = new Deal();
		deal.setDealName("test");
		deal.setDealDesc("test");
		deal.setLastUpdated(new Timestamp(new Date().getTime()));

		Integer dealId = dao.createEntity(deal);
		
		int rowsUpdated= dao.deleteEntity(dealId);
		
		assertNotSame(0, rowsUpdated);

	}
	
	@Test
	public void testSelectDeal() {

		DAO<Deal, Integer> dao = new DealDAO(Deal.class);
		
		Deal deal = dao.findEntityById(100004);
		assertNotNull(deal);

	}
	
	@Test
	public void testSelectAllDeals() {

		DAO<Deal, Integer> dao = new DealDAO(Deal.class);
		
		List<Deal> dealList = dao.findAllEntities();
		assertNotNull(dealList);

	}

}
