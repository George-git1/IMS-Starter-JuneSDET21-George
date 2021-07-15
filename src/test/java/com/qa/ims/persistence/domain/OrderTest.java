package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTest {

	@Test
	public void constructor1() {
		Order id = new Order(1L, 2L);
		assertTrue(id instanceof Order);
	}

	@Test
	public void constructor2() {
		Order id = new Order(1L, 2L);
		assertTrue(id instanceof Order);
	}

	@Test
	public void testGetId() {
		Order id = new Order(1L, 2L);
		Long expected = 1L;
		assertEquals(expected, id.getId());
	}

	@Test
	public void testSetId() {
		Order id = new Order(1L);
		id.setId(3L);
		Long expected = 3L;
		assertEquals(expected, id.getId());
	}

	@Test
	public void testGetCustomerId() {
		Order customerId = new Order(1L);
		Long expected = 1L;
		assertEquals(expected, customerId.getCustomerId());
	}

	@Test
	public void testSetCustomerId() {
		Order customerId = new Order(1L, 2L);
		customerId.setId(2L);
		Long expected = 2L;
		assertEquals(expected, customerId.getCustomerId());
	}


}
