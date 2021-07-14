package com.qa.ims.persistence.domain;


import java.util.Objects;

public class OrderItem {

	private Long orderItemId;
	private Long orderId;
	private Long itemId;
	private int qty;
	private double lineTotal;

	public OrderItem(Long orderItemId, Long orderId, Long itemId) {
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemId = itemId;
	
	}
	
	public OrderItem(Long orderId, Long itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
		
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	



	@Override
	public String toString() {
		return "order item ID: " + orderItemId + " | order ID: " + orderId + " | item ID:" + itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId, orderItemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(itemId, other.itemId)
				&& Double.doubleToLongBits(lineTotal) == Double.doubleToLongBits(other.lineTotal)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(orderItemId, other.orderItemId)
				&& qty == other.qty;
	}

}