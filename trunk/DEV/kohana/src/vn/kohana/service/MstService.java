package vn.kohana.service;

import java.util.List;
import vn.kohana.mst.CategoryMst;

public interface MstService {
	public List<CategoryMst> getAllSupCategories();
	public CategoryMst getCategory(String code);
}
