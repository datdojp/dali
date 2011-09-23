package vn.kohana.bean.client;

import vn.kohana.bean.BaseBean;
import vn.kohana.utils.KohanaConstants;

public class ShowCategoryBean extends BaseBean {
	//action
	private String categoryCode;
	public String init() {
		return KohanaConstants.PAGE_CLIENT_SHOW_CATEGORY;
	}
	
	//getter setter
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
