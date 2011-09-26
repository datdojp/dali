package vn.kohana.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.kohana.dto.CartItem;
import vn.kohana.dto.OrderDto;
import vn.kohana.dto.ProductDto;

public class OrderDao extends BaseDao {
	public OrderDto insert(OrderDto order) {
		getSqlMapClientTemplate().insert("insertOrder", order);
		order.setId(getLastInsertId());
		return order;
	}
	
	public void insertOrderProduct(OrderDto order, ProductDto product, int quantity) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("order", order);
		params.put("product", product);
		params.put("quantity", quantity);
		getSqlMapClientTemplate().insert("insertOrderProduct", params);
	}
	
	public List<OrderDto> search(String statusCode) {
		return getSqlMapClientTemplate().queryForList("searchOrder", statusCode);
	}
	
	public void updateStatus(int id, String statusCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("statusCode", statusCode);
		getSqlMapClientTemplate().update("updateOrderStatus", params);
	}
	
	public List<CartItem> getOrderProduct(int orderId) {
		return getSqlMapClientTemplate().queryForList("getOrderProduct", orderId);
	}
}
