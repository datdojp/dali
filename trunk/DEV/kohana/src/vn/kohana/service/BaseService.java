package vn.kohana.service;

import vn.kohana.dao.ProductDao;

public abstract class BaseService {
	private ProductDao productDao;

	//getter setter
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
}
