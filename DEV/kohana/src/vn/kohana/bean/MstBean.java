package vn.kohana.bean;

import java.util.List;

import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public class MstBean extends BaseBean {
	private List<CategoryMst> allCategories;
	
	public MstBean() {
	}
	
	public void loadSupCategories() {
		allCategories = getMstService().getAllSupCategories();
	}
	
	//getter setter
	public List<CategoryMst> getAllCategories() {
		if(KohanaUtils.isEmpty(allCategories)) {
			loadSupCategories();
		}
		return allCategories;
	}
}
