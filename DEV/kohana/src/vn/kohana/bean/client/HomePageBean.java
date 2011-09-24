package vn.kohana.bean.client;

import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaConstants;

public class HomePageBean extends BaseBean {
	//data
	public List<ProductDto> getSpecialProducts() {
		return getProductService().getAllSpecialProducts();
	}

	public List<ProductDto> getSaleProducts() {
		return getProductService().getAllSaleProducts();
	}
	
	//action
	public String init() {
		return KohanaConstants.PAGE_CLIENT_HOMEPAGE;
	}

	//getter setter
}
