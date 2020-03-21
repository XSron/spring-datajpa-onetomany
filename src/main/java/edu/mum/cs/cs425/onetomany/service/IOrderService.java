package edu.mum.cs.cs425.onetomany.service;


import edu.mum.cs.cs425.onetomany.model.Order;

public interface IOrderService {
	public void saveOrder(Order order);
	public Iterable<Order> getOrders();
	public void deleteOrderById(long id);
}
