package vn.kohana.dao;

import java.util.List;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;

public class ProductDao extends BaseDao {
	public List<ProductDto> search(ProductCriteria criteria) {
		ProductCriteria cloned = (ProductCriteria) criteria.clone();
		cloned.setName(getSQLSearchableString(cloned.getName()));
		return getSqlMapClientTemplate().queryForList("searchProduct", cloned);
	}
	
	public ProductDto insert(ProductDto product) {
		product.setNameSearch(getSearchableString(product.getName()));
		getSqlMapClientTemplate().queryForList("insertProduct", product);
		product.setId(getLastInsertId());
		return product;
	}
	
	public void delete(int id) {
		getSqlMapClientTemplate().delete("deleteProduct", id);
	}
}