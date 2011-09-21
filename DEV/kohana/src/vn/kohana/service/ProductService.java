package vn.kohana.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import vn.kohana.criteria.ProductCriteria;
import vn.kohana.dto.ProductDto;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.KohanaUtils;

public interface ProductService {
	public List<ProductDto> getAllSpecialProducts();
	public List<ProductDto> getAllSaleProducts();
	public List<ProductDto> searchProduct(Integer id, String cateCode, String subcatCode, String name, Boolean special, Boolean sale);
	public ProductDto createProduct(String cateCode, String subcatCode, String name, String detail, Integer price,
			Integer salePrice, Integer quantity, String image, boolean special, boolean sale);
	public void deleteProduct(int id);
}
