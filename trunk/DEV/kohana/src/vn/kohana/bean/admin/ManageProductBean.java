package vn.kohana.bean.admin;

import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.mst.CategoryMst;

public class ManageProductBean extends BaseBean {
	//criteria
	private String id;
	private String cateCode;
	private String subcatCode;
	private String name;
	private boolean special;
	private boolean sale;
	
	//supcat combobox
	private List<CategoryMst> subCats;
	
	
	//ajax
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public List<CategoryMst> getSubCats() {
		return subCats;
	}
	public void setSubCats(List<CategoryMst> subCats) {
		this.subCats = subCats;
	}
}
