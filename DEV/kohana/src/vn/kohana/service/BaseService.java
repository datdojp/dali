package vn.kohana.service;

import vn.kohana.dao.MstDao;
import vn.kohana.dao.OrderDao;
import vn.kohana.dao.ProductDao;

public abstract class BaseService {
	private ProductDao productDao;
	private OrderDao orderDao;
	private MstDao mstDao;

	//getter setter
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public MstDao getMstDao() {
		return mstDao;
	}

	public void setMstDao(MstDao mstDao) {
		this.mstDao = mstDao;
	}
	
	
}
