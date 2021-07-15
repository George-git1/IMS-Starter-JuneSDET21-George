package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderDao;
	@Mock
	private ItemDAO itemDao;

	@Mock
	private OrderItemDAO orderItemDao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long id = 1L;
		final Long customerId = 1L;

		final Order order = new Order(id, customerId);

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(orderDao.create(order)).thenReturn(order);

		assertEquals(order, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(orderDao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}

	@Test
    public void testDelete() {

        final Long ID = 1l;
        List<OrderItem> oi = new ArrayList<>();
        oi.add(new OrderItem(1l,1l,3l));
        oi.add(new OrderItem(2l,4l,1l));


        Mockito.when(utils.getLong()).thenReturn(ID);
        Mockito.when(orderItemDao.readAll()).thenReturn(oi);
        Mockito.when(orderItemDao.delete(1l)).thenReturn(1);
        Mockito.when(orderDao.delete(ID)).thenReturn(1);

        assertEquals(1l, controller.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(orderItemDao, Mockito.times(1)).readAll();
       
	}
}