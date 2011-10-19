package vn.kohana.dto;

import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public class ProductDto extends BaseDto {
	private CategoryMst category;
	private CategoryMst subCat;
	private String name;
	private String nameSearch;
	private String detail;
	private Integer price;
	private Integer salePrice;
	private Integer quantity;
	private String image;
	private boolean special;
	private boolean sale;
	
	//getter setter
	public CategoryMst getCategory() {
		return category;
	}
	public void setCategory(CategoryMst category) {
		this.category = category;
	}
	public CategoryMst getSubCat() {
		return subCat;
	}
	public void setSubCat(CategoryMst subCat) {
		this.subCat = subCat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameSearch() {
		return nameSearch;
	}
	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	public boolean isSale() {
		return sale;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}
}
