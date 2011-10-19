package vn.kohana.bean.client;

import java.util.ArrayList;
import java.util.List;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.utils.KohanaConstants;

public class SearchBean extends BaseBean {
	//criteria
	private String name;
	private String categoryCode;
	private Integer priceFrom;
	private Integer priceTo;

	//results
	private List<ProductDto> results = new ArrayList<ProductDto>();
	
	//action
	public String search() {
		results = getProductService().searchProduct(name, categoryCode, priceFrom, priceTo);
		return KohanaConstants.PAGE_CLIENT_SEARCH_RESULTS;
	}

	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(Integer priceFrom) {
		this.priceFrom = priceFrom;
	}

	public Integer getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Integer priceTo) {
		this.priceTo = priceTo;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public List<ProductDto> getResults() {
		return results;
	}

	public void setResults(List<ProductDto> results) {
		this.results = results;
	}
}
