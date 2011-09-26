package vn.kohana.bean.client;

import java.util.ArrayList;
import java.util.List;
import vn.kohana.bean.BaseBean;
import vn.kohana.dto.CartItem;
import vn.kohana.utils.BeanUtils;
import vn.kohana.utils.KohanaConstants;

public class CartBean extends BaseBean {
	//data
	private List<CartItem> items = new ArrayList<CartItem>();
	
	//action
	private int addedProductId;
	public String add() {
		for(CartItem anItem : items) {
			if(anItem.getProduct().getId().equals(addedProductId)) {
				anItem.setQuantity(anItem.getQuantity() + 1);
				return null;
			}
		}
		items.add(new CartItem(getProductService().getProduct(addedProductId), 1));
		return null;
	}
	public String view() {
		return KohanaConstants.PAGE_CLIENT_SHOW_CART;
	}
	public String order() {
		OrderBean orderBean = (OrderBean) BeanUtils.getContextBean("orderBean");
		orderBean.setItems(items);
		orderBean.setClearCartAfterSubmit(true);
		return KohanaConstants.PAGE_CLIENT_ORDER;
	}
	public String clear() {
		items = new ArrayList<CartItem>();
		return KohanaConstants.PAGE_CLIENT_HOMEPAGE;
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
	public int getAddedProductId() {
		return addedProductId;
	}
	public void setAddedProductId(int addedProductId) {
		this.addedProductId = addedProductId;
	}
}
