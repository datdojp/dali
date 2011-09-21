package vn.kohana.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaUtils;

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
	
	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> searchProduct(Integer id, String cateCode, String subcatCode, String name, Boolean special, Boolean sale) {
		ProductCriteria criteria = new ProductCriteria();
		if(KohanaUtils.isValidId(id)) {
			criteria.setId(id);
		}
		criteria.setCateCode(cateCode);
		criteria.setSubcatCode(subcatCode);
		criteria.setName(name);
		if(special != null) {
			criteria.setSpecial(special);
		}
		if(sale != null) {
			criteria.setSale(sale);
		}
		return getProductDao().searchProducts(criteria);
	}
}
