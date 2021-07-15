package com.qa.ims.persistence.domain;

	import org.junit.Test;

	

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;



	public class ItemTest {
		
	
		
		@Test
		public void constructor1() {
			Item strings = new Item("Super slinky",6.00);
			assertTrue(strings instanceof Item);
		}
		
		@Test
		public void constructor2() {
			Item strings = new Item(1L,"Super slinky",6.00);
			assertTrue(strings instanceof Item);
		}
		
		@Test
		public void testGetId() {
			Item strings = new Item(1L,"Super slinky",6.00);
			Long expected = 1l;
			assertEquals(expected,strings.getId());
		}
		
		@Test
		public void testSetId() {
			Item strings = new Item("Super slinky",6.00);
			strings.setId(3L);
			Long expected = 3L;
			assertEquals(expected,strings.getId());
		}
		
		@Test
		public void testGetName() {
			Item strings = new Item("Super slinky",6.00);
			String expected = "Super slinky";
			assertEquals(expected,strings.getName());
		}
		
		@Test
		public void testSetName() {
			Item strings = new Item("Super slinky",6.00);
			strings.setName("Slinky");
			String expected = "Slinky";
			assertEquals(expected,strings.getName());
		}
		
		@Test
		public void testGetPrice() {
			Item strings = new Item("Super slinky",6.00);
			Double expected = 6.00;
			assertEquals(expected,strings.getPrice());
		}
		
		@Test
		public void testSetPrice() {
			Item strings = new Item("Super slinky",6.00);
			strings.setPrice(8.50);
			Double expected = 8.50;
			assertEquals(expected,strings.getPrice());
		}
	}