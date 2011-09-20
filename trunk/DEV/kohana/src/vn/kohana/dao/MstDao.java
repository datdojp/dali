package vn.kohana.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.kohana.mst.CategoryMst;

public class MstDao extends BaseDao {
	public List<CategoryMst> searchCategory(String code, String supcatCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		params.put("supcatCode", supcatCode);
		return getSqlMapClientTemplate().queryForList("searchCategory", params);
	}
	
}
