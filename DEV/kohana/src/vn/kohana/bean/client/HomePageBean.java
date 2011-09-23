package vn.kohana.bean.client;

import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaConstants;

public class HomePageBean extends BaseBean {
	//data
	private List<ProductDto> specialProducts;
	private List<ProductDto> saleProducts;
	
	//action
	public String init() {
		specialProducts = getProductService().getAllSpecialProducts();
		saleProducts = getProductService().getAllSaleProducts();
		return KohanaConstants.PAGE_CLIENT_HOMEPAGE;
	}

	//getter setter
	public List<ProductDto> getSpecialProducts() {
		return specialProducts;
	}

	public void setSpecialProducts(List<ProductDto> specialProducts) {
		this.specialProducts = specialProducts;
	}

	public List<ProductDto> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(List<ProductDto> saleProducts) {
		this.saleProducts = saleProducts;
	}
}
