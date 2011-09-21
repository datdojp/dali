package vn.kohana.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public class ProductServiceImpl extends BaseService implements ProductService {
	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> getAllSpecialProducts() {
		ProductCriteria criteria = new ProductCriteria();
		criteria.setSpecial(true);
		return getProductDao().search(criteria);
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> getAllSaleProducts() {
		ProductCriteria criteria = new ProductCriteria();
		criteria.setSale(true);
		return getProductDao().search(criteria);
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
		return getProductDao().search(criteria);
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public ProductDto createProduct(String cateCode, String subcatCode, String name, String detail, Integer price,
			Integer salePrice, Integer quantity, String image, boolean special, boolean sale) {
		ProductDto product = new ProductDto();
		product.setCategory(new CategoryMst());
		product.getCategory().setCode(cateCode);
		product.setSubCat(new CategoryMst());
		product.getSubCat().setCode(subcatCode);
		product.setName(name);
		product.setDetail(detail);
		product.setPrice(price);
		product.setSalePrice(salePrice);
		product.setQuantity(quantity);
		product.setImage(image);
		product.setSpecial(special);
		product.setSale(sale);
		return getProductDao().insert(product);
	}
	
	@Transactional(rollbackFor=DataAccessException.class)
	public void deleteProduct(int id) {
		getProductDao().delete(id);
	}
}
