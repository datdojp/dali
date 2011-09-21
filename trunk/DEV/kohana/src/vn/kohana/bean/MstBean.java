package vn.kohana.bean;

import java.util.List;

import vn.kohana.mst.CategoryMst;

public class MstBean extends BaseBean {
	private List<CategoryMst> allCategories;
	
	public MstBean() {
		loadSupCategories();
	}
	
	public void loadSupCategories() {
		allCategories = getMstService().getAllSupCategories();
	}
	
	//getter setter
	public List<CategoryMst> getAllCategories() {
		return allCategories;
	}

	public void setAllCategories(List<CategoryMst> allSupCategories) {
		this.allCategories = allSupCategories;
	}
}
