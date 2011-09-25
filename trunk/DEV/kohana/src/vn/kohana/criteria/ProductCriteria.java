package vn.kohana.criteria;

public class ProductCriteria extends BaseCriteria {
	private String cateCode;
	private String subcatCode;
	private String name;
	private Boolean special = null;
	private Boolean sale = null;
	private Integer priceFrom;
	private Integer priceTo;
	
	//getter setter
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
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getSubcatCode() {
		return subcatCode;
	}
	public void setSubcatCode(String subcatCode) {
		this.subcatCode = subcatCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(Integer priceFrom) {
		this.priceFrom = priceFrom;
	}
	public Integer getPriceTo() {
		return priceTo;
	}
	public void setPriceTo(Integer priceTo) {
		this.priceTo = priceTo;
	}
	
}
