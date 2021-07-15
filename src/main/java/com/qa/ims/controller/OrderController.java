package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private OrderItemDAO orderItemDAO;
	private CustomerDAO customerDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, ItemDAO itemDAO, OrderItemDAO orderItemDAO, CustomerDAO customerDAO,
			Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.itemDAO = itemDAO;
		this.orderItemDAO = orderItemDAO;
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customer Id");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");

		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order");
		Long orderId = utils.getLong();
		Order order = orderDAO.read(orderId);
		LOGGER.info("You may add any of the following items that are avialable");
		addItem(order);
		removeItem(order);
		return order;

	}

	@Override
	public int delete() {
		LOGGER.info("Enter the id of the order you wish to delete");
		Long id = utils.getLong();
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			if (orderItem.getOrderId() == id) {
				orderItemDAO.delete(orderItem.getItemId());
			}
		}
		return orderDAO.delete(id);
	}

// shows list of items that can be added by .get/ updates order from id, customer id and price and returns the updated order when read

	private Order addItem(Order order) {
		List<Item> items = itemDAO.readAll();
		LOGGER.info("Listed are the items that are available to add to your order");
		for (Item item : items) {
			LOGGER.info(item.getName());
		}
		LOGGER.info("Add an item from the list below Enter 'Finished' when you're done adding to your order");
		String newItem = utils.getString();
		if (newItem.equalsIgnoreCase("FiniSheD")) {
			return order;
		} else {
			Long itemId = (long) -1;
			for (Item it : items) {
				if (it.getName().equalsIgnoreCase(newItem)) {
					itemId = it.getId();
				}
			}
			if (itemId != -1) {
				Item item = itemDAO.read(itemId);
				Order updatedOrder = orderDAO
						.update(new Order(order.getId(), (long) (order.getCustomerId() + item.getPrice())));

				return addItem(updatedOrder);
				
			}
		return order;
		}
		
	}

	private Long removeItem(Order order) {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemId = utils.getLong();
		return (long) orderDAO.delete(itemId);

	}

}
