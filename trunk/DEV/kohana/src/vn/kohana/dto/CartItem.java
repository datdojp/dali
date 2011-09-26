package vn.kohana.dto;

import java.io.Serializable;


public class CartItem implements Serializable {
	//data
	private ProductDto product;
	private int quantity;
	
	//constructor
	public CartItem(){}
	public CartItem(ProductDto product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	//getter setter
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
