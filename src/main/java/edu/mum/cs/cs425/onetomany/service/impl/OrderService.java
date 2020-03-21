package edu.mum.cs.cs425.onetomany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.onetomany.model.Order;
import edu.mum.cs.cs425.onetomany.repository.OrderRepository;
import edu.mum.cs.cs425.onetomany.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public void saveOrder(Order order) {
		if(order != null)
			orderRepository.save(order);
	}
	@Override
	public Iterable<Order> getOrders() {
		return orderRepository.findAll();
	}
	@Override
	public void deleteOrderById(long id) {
		orderRepository.deleteById(id);
	}
}
