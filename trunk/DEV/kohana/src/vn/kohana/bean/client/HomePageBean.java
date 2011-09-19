package vn.kohana.bean.client;

import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaConstants;

public class HomePageBean extends BaseBean {
	private List<ProductDto> specialProducts;
	private List<ProductDto> saleProducts;
	
	public String init() {
		specialProducts = getProductService().getAllSpecialProducts();
		saleProducts = getProductService().getAllSaleProducts();
		return KohanaConstants.PAGE_CLIENT_HOMEPAGE;
	}
}
