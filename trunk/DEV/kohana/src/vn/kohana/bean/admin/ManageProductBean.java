package vn.kohana.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.BeanUtils;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class ManageProductBean extends BaseBean {
	//log
	private Logger logger = Logger.getLogger(ManageProductBean.class);
	
	//criteria
	private String id;
	private String cateCode;
	private String subcatCode;
	private String name;
	private String special;
	private String sale;
	
	//results
	private List<ProductDto> searchResults;
	public int getnSearchResults() {
		if(KohanaUtils.isEmpty(searchResults)) {
			return 0;
		} else {
			return searchResults.size();
		}
	}
	
	//supcat combobox
	private List<CategoryMst> subCats;
	
	
	//action
	public String init() {
		return KohanaConstants.PAGE_ADMIN_MANAGE_PRODUCT;
	}
	public String loadSubCats() {
		if(!KohanaUtils.isEmpty(cateCode)) {
			CategoryMst cat = getMstService().getCategory(cateCode);
			subCats = cat.getSubcats();
		} else {
			subCats = new ArrayList<CategoryMst>();
		}
		return null;
	}
	public String search() {
		Integer intId = null;
		if(!KohanaUtils.isEmpty(id)) {
			try {
				intId = Integer.parseInt(id);
			} catch (NumberFormatException ex) {
				BeanUtils.getMessageBean().setMessage("ID phải là số");
				return null;
			}
		}
		searchResults = getProductService().searchProduct(intId, cateCode, subcatCode, name,
				KohanaUtils.stringToBoolean(special, "both", "special", "normal"),
				KohanaUtils.stringToBoolean(sale, "both", "sale", "nosale"));
		return null;
	}
	public String clear() {
		id = null;
		cateCode = null;
		subcatCode = null;
		subCats = new ArrayList<CategoryMst>();
		name = null;
		special = "both";
		sale = "both";
		searchResults = new ArrayList<ProductDto>();
		return null;
	}
	private int deletedProductId;
	public String delete() {
		try {
			getProductService().deleteProduct(deletedProductId);
			search();
		} catch (Exception ex) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_COMMON_ERROR);
			logger.error(ex);
		}
		return null;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getSubcatCode() {
		return subcatCode;
	}
	public void setSubcatCode(String subcatCode) {
		this.subcatCode = subcatCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public List<CategoryMst> getSubCats() {
		return subCats;
	}
	public void setSubCats(List<CategoryMst> subCats) {
		this.subCats = subCats;
	}

	public List<ProductDto> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<ProductDto> searchResults) {
		this.searchResults = searchResults;
	}

	public int getDeletedProductId() {
		return deletedProductId;
	}

	public void setDeletedProductId(int deletedProductId) {
		this.deletedProductId = deletedProductId;
	}
}
