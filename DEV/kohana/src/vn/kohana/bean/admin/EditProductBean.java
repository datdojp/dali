package vn.kohana.bean.admin;

import java.util.List;

import org.apache.log4j.Logger;

import vn.kohana.bean.BaseBean;
import vn.kohana.dto.ProductDto;
import vn.kohana.mst.CategoryMst;
import vn.kohana.utils.BeanUtils;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class EditProductBean extends BaseBean {
	//logger
	private Logger logger = Logger.getLogger(EditProductBean.class);
	
	//fields
	private Integer id;
	private String cateCode;
	private String subcatCode;
	private String name;
	private String detail;
	private String price;
	private String salePrice;
	private String quantity;
	private String image;
	private boolean special;
	private boolean sale;
	
	//supcat combobox
	private List<CategoryMst> subCats;
	
	//action
	private int edittedProductId;
	public String init() {
		ProductDto product = getProductService().getProduct(edittedProductId);
		id = product.getId();
		cateCode = product.getCategory().getCode();
		subcatCode = product.getSubCat().getCode();
		name = product.getName();
		detail = product.getDetail();
		price = KohanaUtils.integerToString(product.getPrice());
		salePrice = KohanaUtils.integerToString(product.getSalePrice());
		quantity = KohanaUtils.integerToString(product.getQuantity());
		image = product.getImage();
		special = product.isSpecial();
		sale = product.isSale();
		subCats = getMstService().getCategory(cateCode).getSubcats();
		return KohanaConstants.PAGE_ADMIN_EDIT_PRODUCT;
	}
	public String loadSubCats() {
		CategoryMst cat = getMstService().getCategory(cateCode);
		subCats = cat.getSubcats();
		return null;
	}
	public String update() {
		if(KohanaUtils.isEmpty(name)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Tên");
			return null;
		}
		Integer intPrice = null;
		if(!KohanaUtils.isEmpty(price)) {
			try {
				intPrice = Integer.parseInt(price);
			} catch (NumberFormatException ex) {
				BeanUtils.getMessageBean().setMessage("Giá phải là số.");
				return null;
			}
		}
		
		Integer intSalePrice = null;
		if(!KohanaUtils.isEmpty(salePrice)) {
			try {
				intSalePrice = Integer.parseInt(salePrice);
			} catch (NumberFormatException ex) {
				BeanUtils.getMessageBean().setMessage("Giá khuyến mãi phải là số.");
				return null;
			}
		}
		
		Integer intQuantity = null;
		if(!KohanaUtils.isEmpty(quantity)) {
			try {
				intQuantity = Integer.parseInt(quantity);
			} catch (NumberFormatException ex) {
				BeanUtils.getMessageBean().setMessage("Số lượng phải là số.");
				return null;
			}
		}
		
		try {
			getProductService().updateProduct(id, cateCode, subcatCode, name, detail,
					intPrice, intSalePrice, intQuantity, image, special, sale);
			BeanUtils.getMessageBean().setMessage("Sửa thông tin sản phẩm thành công");
			((ManageProductBean)BeanUtils.getContextBean("manageProductBean")).search();
			return KohanaConstants.PAGE_ADMIN_MANAGE_PRODUCT;
		} catch (Exception ex) {
			BeanUtils.getMessageBean().setMessage("Có lỗi trong quá trình sửa thông tin sản phẩm. Hãy thử lại.");
			logger.error(ex);
		}
		
		return null;
	}
	
	//getter setter
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	public boolean isSale() {
		return sale;
	}
	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<CategoryMst> getSubCats() {
		return subCats;
	}

	public void setSubCats(List<CategoryMst> subCats) {
		this.subCats = subCats;
	}
	public int getEdittedProductId() {
		return edittedProductId;
	}
	public void setEdittedProductId(int edittedProductId) {
		this.edittedProductId = edittedProductId;
	}
}
