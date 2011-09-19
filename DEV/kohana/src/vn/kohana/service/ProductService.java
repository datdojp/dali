package vn.kohana.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;

public class ProductService extends BaseService {
	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> getAllSpecialProducts() {
		ProductCriteria criteria = new ProductCriteria();
		criteria.setSpecial(true);
		return getProductDao().searchProducts(criteria);
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> getAllSaleProducts() {
		ProductCriteria criteria = new ProductCriteria();
		criteria.setSale(true);
		return getProductDao().searchProducts(criteria);
	}
}
