package vn.kohana.dao;

import java.util.List;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;

public class ProductDao extends BaseDao {
	public List<ProductDto> searchProducts(ProductCriteria criteria) {
		ProductCriteria cloned = (ProductCriteria) criteria.clone();
		cloned.setName(getSQLSearchableString(cloned.getName()));
		return getSqlMapClientTemplate().queryForList("searchProduct", cloned);
	}
}