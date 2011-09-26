package vn.kohana.service;

import java.util.List;

import vn.kohana.dto.CartItem;
import vn.kohana.dto.OrderDto;

public interface OrderService {
	public OrderDto createOrder(String orderByName, String orderByPhone, String orderByAddress,
			String orderForName, String orderForPhone, String orderForAddress,
			String paymentCode, String bankName, String bankAccountNumber, List<CartItem> items);
	public List<OrderDto> searchOrderByStatus(String statusCode);
	public void updateOrderStatus(int id, String statusCode);
	public List<CartItem> getOrderItems(int orderId);
}
