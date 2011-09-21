package vn.kohana.bean;

import java.io.Serializable;

import vn.kohana.service.MstService;
import vn.kohana.service.OrderService;
import vn.kohana.service.ProductService;

public abstract class BaseBean implements Serializable {
	private ProductService productService;
	private OrderService orderService;
	private MstService mstService;
	
	//getter setter
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public MstService getMstService() {
		return mstService;
	}
	public void setMstService(MstService mstService) {
		this.mstService = mstService;
	}
}
