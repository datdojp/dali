package vn.kohana.bean;

import java.util.List;

import vn.kohana.mst.CategoryMst;

public class MstBean extends BaseBean {
	private List<CategoryMst> allSupCategories;
	
	public MstBean() {
		loadSupCategories();
	}
	
	public void loadSupCategories() {
		allSupCategories = getMstService().getAllSupCategories();
	}
	
	//getter setter
	public List<CategoryMst> getAllSupCategories() {
		return allSupCategories;
	}

	public void setAllSupCategories(List<CategoryMst> allSupCategories) {
		this.allSupCategories = allSupCategories;
	}
}
