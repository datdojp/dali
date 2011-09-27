package vn.kohana.bean.client;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.CartItem;
import vn.kohana.utils.BeanUtils;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class CartBean extends BaseBean {
	//data
	private List<CartItem> items = new ArrayList<CartItem>();
	
	//action
	public void add(AjaxBehaviorEvent event) {
		Integer addedProductId = Integer.parseInt(BeanUtils.getRequest().getParameter("addedProductId"));
		boolean found = false;
		for(CartItem anItem : items) {
			if(anItem.getProduct().getId().equals(addedProductId)) {
				anItem.setQuantity(anItem.getQuantity() + 1);
				found = true;
				break;
			}
		}
		if(!found) {
			items.add(new CartItem(getProductService().getProduct(addedProductId), 1));
		}
	}
	public String view() {
		return KohanaConstants.PAGE_CLIENT_SHOW_CART;
	}
	public String order() {
		//check quantity
		String notSufficientProducts = "";
		for(CartItem anItem : items) {
			//refresh
			anItem.setProduct(getProductService().getProduct(anItem.getProduct().getId()));
			if(anItem.getProduct().getQuantity() != null) {
				if(anItem.getQuantity() > anItem.getProduct().getQuantity()) {
					if(!KohanaUtils.isEmpty(notSufficientProducts)) {
						notSufficientProducts = notSufficientProducts + ", ";
					}
					notSufficientProducts = notSufficientProducts + anItem.getProduct().getName() + "(còn " + anItem.getProduct().getQuantity() + ")";
				}
			}
		}
		if(!KohanaUtils.isEmpty(notSufficientProducts)) {
			BeanUtils.getMessageBean().setMessage("Các sản phẩm sau không đủ số lượng: " + notSufficientProducts);
			return null;
		}
		
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
}
