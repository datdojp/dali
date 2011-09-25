package vn.kohana.dto;

import java.util.Date;

import vn.kohana.mst.OrderStatusMst;
import vn.kohana.mst.PaymentMst;

public class OrderDto extends BaseDto {
	//data
	private OrderStatusMst status;
	private String orderByName;
	private String orderByPhone;
	private String orderByAddress;
	private String orderForName;
	private String orderForPhone;
	private String orderForAddress;
	private PaymentMst payment;
	private String bankName;
	private String bankAccountNumber;
	private Date time;
	
	//getter setter
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
