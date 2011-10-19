package vn.kohana.service;

import java.util.ArrayList;
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

	@Transactional(rollbackFor=DataAccessException.class)
	public ProductDto getProduct(int id) {
		ProductCriteria criteria = new ProductCriteria();
		criteria.setId(id);
		return getProductDao().search(criteria).get(0);
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public void updateProduct(Integer id, String cateCode,
			String subcatCode, String name, String detail, Integer price,
			Integer salePrice, Integer quantity, String image, boolean special,
			boolean sale) {
		ProductDto product = new ProductDto();
		product.setId(id);
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
		getProductDao().update(product);
	}

	@Transactional(rollbackFor=DataAccessException.class)
	public List<ProductDto> searchProduct(String name, String code, String cateCode, Integer priceFrom, Integer priceTo) {
		ProductCriteria criteria = new ProductCriteria();
		if(!KohanaUtils.isEmpty(name)) {
			criteria.setName(name);
		}
		if(!KohanaUtils.isEmpty(cateCode)) {
			criteria.setCateCode(cateCode);
		}
		if(priceFrom != null && priceFrom >= 0) {
			criteria.setPriceFrom(priceFrom);
		}
		if(priceTo != null && priceTo >= 0) {
			criteria.setPriceTo(priceTo);
		}
		if(!KohanaUtils.isEmpty(code)) {
//			if(code.length() <= 3) {
//				return new ArrayList<ProductDto>();
//			}
//			String strId = code.substring(3);
			String strId = code;
			Integer id = null;
			try {
				id = Integer.parseInt(strId);
			} catch (NumberFormatException ex) {
				return new ArrayList<ProductDto>();
			}
			
			criteria.setId(id);
		}
		
		return getProductDao().search(criteria);
	}
}
