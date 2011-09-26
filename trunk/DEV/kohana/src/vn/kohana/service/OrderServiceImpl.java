package vn.kohana.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.CartItem;
import vn.kohana.dto.OrderDto;
import vn.kohana.mst.OrderStatusMst;
import vn.kohana.mst.PaymentMst;

public class OrderServiceImpl extends BaseService implements OrderService {
	@Transactional(rollbackFor=DataAccessException.class)
	public OrderDto createOrder(String orderByName, String orderByPhone,
			String orderByAddress, String orderForName, String orderForPhone,
			String orderForAddress, String paymentCode, String bankName,
			String bankAccountNumber, List<CartItem> items) {
		OrderDto order = new OrderDto();
		order.setOrderByName(orderByName);
		order.setOrderByPhone(orderByPhone);
		order.setOrderByAddress(orderByAddress);
		order.setOrderForName(orderForName);
		order.setOrderForPhone(orderForPhone);
		order.setOrderForAddress(orderForAddress);
		order.setStatus(new OrderStatusMst());
		order.getStatus().setCode("NEW");
		order.setPayment(new PaymentMst());
		order.getPayment().setCode(paymentCode);
		if("TRF".equals(paymentCode)) {
			order.setBankName(bankName);
			order.setBankAccountNumber(bankAccountNumber);
		}
		order = getOrderDao().insert(order);
		for (CartItem anItem : items) {
			getOrderDao().insertOrderProduct(order, anItem.getProduct(), anItem.getQuantity());
		}
		return order;
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public List<OrderDto> searchOrderByStatus(String statusCode) {
		return getOrderDao().search(statusCode);
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void updateOrderStatus(int id, String statusCode) {
		getOrderDao().updateStatus(id, statusCode);
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public List<CartItem> getOrderItems(int orderId) {
		List<CartItem> items = getOrderDao().getOrderProduct(orderId);
		for (CartItem anItem : items) {
			ProductCriteria criteria = new ProductCriteria();
			criteria.setId(anItem.getProduct().getId());
			anItem.setProduct(getProductDao().search(criteria).get(0));
		}
		return items;
	}

}
