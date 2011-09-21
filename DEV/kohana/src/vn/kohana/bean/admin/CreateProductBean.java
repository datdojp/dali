package vn.kohana.bean.admin;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import vn.kohana.bean.BaseBean;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaConstants;

public class CreateProductBean extends BaseBean {
	//fields
	private String cateCode;
	private String subcatCode;
	private String name;
	private String detail;
	private Long price;
	private Long salePrice;
	private Long quantity;
	private String image;
	private boolean special;
	private boolean sale;
	
	//supcat combobox
	private List<CategoryMst> subCats;
	
	//ajax
	public void loadSubCats(AjaxBehaviorEvent e) {
		CategoryMst cat = getMstService().getCategory(cateCode);
		subCats = cat.getSubcats();
	}
	
	//action
	public String init() {
		return KohanaConstants.PAGE_ADMIN_CREATE_PRODUCT;
	}
	
	//getter setter
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
