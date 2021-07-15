package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(5L, "Adapter", 3.50);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Ernie ball Strings", 5.40));
		expected.add(new Item(2L, "Adapter", 3.50));
		expected.add(new Item(3L, "Sausage", 4.00));
		expected.add(new Item(4L, "EMG humbuckers", 145.23));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(4L, "EMG humbuckers", 145.23), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 4L;
		assertEquals(new Item(ID, "EMG humbuckers", 145.23), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(4L, "EEMG humbuckers", 145.23);
		assertEquals(updated, DAO.update(updated));

	}

	/*
	 * @Test public void testDelete() { assertEquals(1L, DAO.delete(1L)); }
	 */
}
