package vn.kohana.bean.admin;

import java.util.List;
import vn.kohana.bean.BaseBean;
import vn.kohana.dto.OrderDto;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class ManageOrderBean extends BaseBean {
	//data
	private String statusCode = "NEW";
	private List<OrderDto> orders;
	
	//action
	public String load() {
		orders = getOrderService().searchOrderByStatus(statusCode);
		return KohanaConstants.PAGE_ADMIN_MANAGE_ORDER;
	}
	private int id;
	private String desStatusCode;
	public String changeStatusForAnOrder() {
		getOrderService().updateOrderStatus(id, desStatusCode);
		
		//success, remove it from orders
		int idx = KohanaUtils.getDtoIndex(id, orders);
		orders.remove(idx);
		
		return null;
	}

	//getter setter
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesStatusCode() {
		return desStatusCode;
	}

	public void setDesStatusCode(String desStatusCode) {
		this.desStatusCode = desStatusCode;
	}
	
}
