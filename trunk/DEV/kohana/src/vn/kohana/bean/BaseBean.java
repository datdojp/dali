package vn.kohana.bean;

import java.io.Serializable;

import vn.kohana.service.ProductService;

public abstract class BaseBean implements Serializable {
	private ProductService productService;

	//getter setter
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
}
