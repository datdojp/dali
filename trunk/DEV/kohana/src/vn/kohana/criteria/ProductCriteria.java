package vn.kohana.criteria;

public class ProductCriteria extends BaseCriteria {
	private Boolean special = null;
	private Boolean sale = null;
	
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
}
