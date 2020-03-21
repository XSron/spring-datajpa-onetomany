package edu.mum.cs.cs425.onetomany;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.onetomany.model.Order;
import edu.mum.cs.cs425.onetomany.model.OrderDetail;
import edu.mum.cs.cs425.onetomany.service.IOrderService;

@SpringBootApplication
public class OnetomanyApplication implements CommandLineRunner {
	@Autowired
	private IOrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//save data
		List<OrderDetail> orderDetails = Arrays.asList(
				new OrderDetail("Coke", 100, 5.6),
				new OrderDetail("Pepsi", 200, 4.5),
				new OrderDetail("Monster", 300, 23.6),
				new OrderDetail("Redbull", 400, 32.6));
		Order order = new Order("#00001", LocalDate.now(), orderDetails);
		for(OrderDetail od: orderDetails)
			od.setOrder(order);
		orderService.saveOrder(order);
		
		//load data
		System.out.println("-----BEFORE DELETE-----");
		Iterable<Order> loadOrder = orderService.getOrders();
		for(Order od: loadOrder) {
			System.out.println(od.getReceiptNo() + " - " + od.getOrderDate());
			for(OrderDetail odd: od.getOrderDetail())
				System.out.println(odd.toString());
		}
		//delete data
		orderService.deleteOrderById(1);
		//reload data
		System.out.println("-----AFTER DELETED-----");
		loadOrder = orderService.getOrders();
		for(Order od: loadOrder) {
			System.out.println(od.getReceiptNo() + " - " + od.getOrderDate());
			for(OrderDetail odd: od.getOrderDetail())
				System.out.println(odd.toString());
		}
	}
}
