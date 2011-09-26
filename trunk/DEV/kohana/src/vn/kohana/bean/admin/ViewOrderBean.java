package vn.kohana.bean.admin;

import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.CartItem;
import vn.kohana.utils.KohanaConstants;

public class ViewOrderBean extends BaseBean {
	//data
	private List<CartItem> items;
	
	//action
	private int orderId;
	public String init() {
		items = getOrderService().getOrderItems(orderId);
		return KohanaConstants.PAGE_ADMIN_VIEW_ORDER;
	}
	
	//utils
	public int getTotalQuantity() {
		int result = 0;
		for(CartItem anItem : items) {
			result += anItem.getQuantity();
		}
		return result;
	}
	public int getTotalMoney() {
		int result = 0;
		for(CartItem anItem : items) {
			if(anItem.getProduct().isSale()) {
				result += anItem.getProduct().getSalePrice() * anItem.getQuantity();
			} else {
				result += anItem.getProduct().getPrice() * anItem.getQuantity();
			}
		}
		return result;
	}
	
	//getter setter
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
