package edu.mum.cs.cs425.onetomany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "orderdetails")
@Entity
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderDetailId;
	private String itemName;
	private int qty;
	private double price;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	public OrderDetail() {}
	public OrderDetail(String itemName, int qty, double price) {
		super();
		this.itemName = itemName;
		this.qty = qty;
		this.price = price;
	}
	public long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", itemName=" + itemName + ", qty=" + qty + ", price="
				+ price + ", order=" + order + "]";
	}
}
