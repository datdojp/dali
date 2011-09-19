package vn.kohana.dto;

import vn.kohana.mst.CategoryMst;

public class ProductDto extends BaseDto {
	private CategoryMst category;
	private CategoryMst subCat;
	private String name;
	private String nameSearch;
	private String detail;
	private Long price;
	private Long salePrice;
	private Long quantity;
	private String image;
	private Boolean special;
	private Boolean sale;
	
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Long salePrice) {
		this.salePrice = salePrice;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getSpecial() {
		return special;
	}
	public void setSpecial(Boolean special) {
		this.special = special;
	}
	public Boolean getSale() {
		return sale;
	}
	public void setSale(Boolean sale) {
		this.sale = sale;
	}
	public String getNameSearch() {
		return nameSearch;
	}
	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
}
