package vn.kohana.dao;

import java.util.List;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;

public class ProductDao extends BaseDao {
	public List<ProductDto> searchProducts(ProductCriteria criteria) {
		return getSqlMapClientTemplate().queryForList("searchProduct", criteria);
	}
}