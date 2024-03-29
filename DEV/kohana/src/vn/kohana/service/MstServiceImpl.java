package vn.kohana.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public class MstServiceImpl extends BaseService implements MstService {
	@Transactional(rollbackFor=DataAccessException.class)
	public List<CategoryMst> getAllSupCategories() {
		List<CategoryMst> results = getMstDao().searchCategory(null, null);
		for(CategoryMst supcat : results) {
			loadSubcats(supcat);
		}
		return results;
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public CategoryMst getCategory(String code) {
		List<CategoryMst> results = getMstDao().searchCategory(code, null);
		if(!KohanaUtils.isEmpty(results)) {
			return loadSubcats(results.get(0));
		} else {
			return null;
		}
	}
	
	private CategoryMst loadSubcats(CategoryMst cat) {
		cat.setSubcats(getMstDao().searchCategory(null, cat.getCode()));
		return cat;
	}
}
