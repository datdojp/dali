package vn.kohana.mst;

import java.util.List;

import vn.kohana.dto.ProductDto;

public class CategoryMst extends BaseMst {
	private String name;
	private String image;
	private CategoryMst supcat;
	
	//transient
	private List<CategoryMst> subcats;
	private List<ProductDto> products;
	
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<CategoryMst> getSubcats() {
		return subcats;
	}
	public void setSubcats(List<CategoryMst> subcats) {
		this.subcats = subcats;
	}
	public CategoryMst getSupcat() {
		return supcat;
	}
	public void setSupcat(CategoryMst supcat) {
		this.supcat = supcat;
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

}
