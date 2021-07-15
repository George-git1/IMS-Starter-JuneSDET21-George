package com.qa.ims.persistence.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	public class CustomerTest { 

	
		
		
		@Test
		public void constructor1() {
			Customer george = new Customer(1L,"George","Whyte");
			assertTrue(george instanceof Customer);
		}
		
		@Test
		public void constructor2() {
			Customer george = new Customer(1L,"George","Whyte");
			assertTrue(george instanceof Customer);
		}
		
		@Test
		public void testGetId() {
			Customer george = new Customer(1L,"George","Whyte");
			Long expected = 1L;
			assertEquals(expected, george.getId());
		}
		
		@Test
		public void testSetId() {
			Customer george = new Customer("George","Whyte");
			george.setId(2L);
			Long expected = 2L;
			assertEquals(expected, george.getId());
		}
		
		@Test
		public void testGetFirstName() {
			Customer george = new Customer(1L,"George","Whyte");
			String expected = "George";
			assertEquals(expected, george.getFirstName());
		}
		
		@Test
		public void testSetFirstName() {
			Customer george = new Customer(1L,"George","Whyte");
			george.setFirstName("GeorgeW");
			String expected = "GeorgeW";
			assertEquals(expected, george.getFirstName());
		}
		
		@Test
		public void testGetSurname() {
			Customer george = new Customer("George","Whyte");
			String expected = "Whyte";
			assertEquals(expected, george.getSurname());
		}
		
		@Test
		public void testSetSurname() {
			Customer george = new Customer("George","Whyte");
			george.setSurname("Whyte");
			String expected = "Whyte";
			assertEquals(expected, george.getSurname());
		}
		
	
	}