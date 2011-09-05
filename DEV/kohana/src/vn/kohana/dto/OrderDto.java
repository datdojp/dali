package vn.kohana.dto;

import vn.kohana.mst.OrderStatusMst;
import vn.kohana.mst.PaymentMst;

public class OrderDto extends BaseDto {
	private OrderStatusMst status;
	private String orderByName;
	private String orderByPhone;
	private String orderByAddress;
	private String orderForName;
	private String orderForPhone;
	private String orderForAddress;
	private PaymentMst payment;
	
	public OrderStatusMst getStatus() {
		return status;
	}
	public void setStatus(OrderStatusMst status) {
		this.status = status;
	}
	public String getOrderByName() {
		return orderByName;
	}
	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}
	public String getOrderByPhone() {
		return orderByPhone;
	}
	public void setOrderByPhone(String orderByPhone) {
		this.orderByPhone = orderByPhone;
	}
	public String getOrderByAddress() {
		return orderByAddress;
	}
	public void setOrderByAddress(String orderByAddress) {
		this.orderByAddress = orderByAddress;
	}
	public String getOrderForName() {
		return orderForName;
	}
	public void setOrderForName(String orderForName) {
		this.orderForName = orderForName;
	}
	public String getOrderForPhone() {
		return orderForPhone;
	}
	public void setOrderForPhone(String orderForPhone) {
		this.orderForPhone = orderForPhone;
	}
	public String getOrderForAddress() {
		return orderForAddress;
	}
	public void setOrderForAddress(String orderForAddress) {
		this.orderForAddress = orderForAddress;
	}
	public PaymentMst getPayment() {
		return payment;
	}
	public void setPayment(PaymentMst payment) {
		this.payment = payment;
	}
}
