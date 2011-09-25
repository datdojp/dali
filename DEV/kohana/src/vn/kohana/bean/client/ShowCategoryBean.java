package vn.kohana.bean.client;

import vn.kohana.bean.BaseBean;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaConstants;

public class ShowCategoryBean extends BaseBean {
	//data
	private CategoryMst category;
	
	//action
	private String categoryCode;
	public String init() {
		category = getMstService().getCategory(categoryCode);
		for(CategoryMst subCat : category.getSubcats()) {
			subCat.setProducts(getProductService().searchProduct(null, categoryCode, subCat.getCode(), null, null, null));
		}
		return KohanaConstants.PAGE_CLIENT_SHOW_CATEGORY;
	}
	
	//getter setter
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public CategoryMst getCategory() {
		return category;
	}

	public void setCategory(CategoryMst category) {
		this.category = category;
	}
}
