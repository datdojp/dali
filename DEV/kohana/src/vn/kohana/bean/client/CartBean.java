package vn.kohana.bean.client;

import java.util.ArrayList;
import java.util.List;
import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class CartBean extends BaseBean {
	//data
	private List<ProductDto> products = new ArrayList<ProductDto>();
	private List<Integer> quantities = new ArrayList<Integer>();
	
	//action
	private int addedProductId;
	private int addedQuantity;
	public String add() {
		int idx = KohanaUtils.getDtoIndex(addedProductId, products);
		if(idx < 0) {
			products.add(getProductService().getProduct(addedProductId));
			quantities.add(addedQuantity);
		} else {
			int quantity = quantities.get(idx) + addedQuantity;
			quantities.set(idx, quantity);
		}
		
		return null;
	}
	public String view() {
		return KohanaConstants.PAGE_CLIENT_SHOW_CART;
	}
	
	//utils
	public int getTotalQuantity() {
		int result = 0;
		for(Integer aQuant : quantities) {
			result += aQuant;
		}
		return result;
	}
	public int getTotalMoney() {
		int result = 0;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).isSale()) {
				result += products.get(i).getSalePrice() * quantities.get(i);
			} else {
				result += products.get(i).getPrice() * quantities.get(i);
			}
		}
		return result;
	}

	//getter setter
	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public List<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}

	public int getAddedProductId() {
		return addedProductId;
	}

	public void setAddedProductId(int addedProductId) {
		this.addedProductId = addedProductId;
	}

	public int getAddedQuantity() {
		return addedQuantity;
	}

	public void setAddedQuantity(int addedQuantity) {
		this.addedQuantity = addedQuantity;
	}
}
