package vn.kohana.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public class MstService extends BaseService {
	@Transactional(rollbackFor=DataAccessException.class)
	public List<CategoryMst> getAllSupCategories() {
		List<CategoryMst> results = getMstDao().searchCategory(null, null);
		for(CategoryMst supcat : results) {
			supcat.setSubcats(getMstDao().searchCategory(null, supcat.getCode()));
		}
		return results;
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public CategoryMst getCategory(String code) {
		List<CategoryMst> results = getMstDao().searchCategory(code, );
		if(!KohanaUtils.isEmpty(results)) {
			return results.get(0);
		} else {
			return null;
		}
	}
}
