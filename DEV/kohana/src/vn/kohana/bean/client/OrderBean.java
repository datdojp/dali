package vn.kohana.bean.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import vn.kohana.bean.BaseBean;
import vn.kohana.utils.BeanUtils;
import vn.kohana.utils.KohanaConstants;
import vn.kohana.utils.KohanaUtils;

public class OrderBean extends BaseBean {
	//logger
	private Logger logger = Logger.getLogger(OrderBean.class);
	
	//data
	List<CartItem> items;
	private String orderByName;
	private String orderByPhone;
	private String orderByAddress;
	private boolean theSame;
	private String orderForName;
	private String orderForPhone;
	private String orderForAddress;
	private String paymentCode;
	private String bankName;//for bank transfer only
	private String bankAccountNumber;//for bank transfer only
	
	//action
	private int orderedProductId;
	private boolean clearCartAfterSubmit;
	public String orderOne() {
		items = new ArrayList<CartItem>();
		items.add(new CartItem(getProductService().getProduct(orderedProductId), 1));
		clearCartAfterSubmit = false;
		return KohanaConstants.PAGE_CLIENT_ORDER;
	}
	public String submit() {
		if(KohanaUtils.isEmpty(orderByName)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Tên người đặt");
			return null;
		}
		if(KohanaUtils.isEmpty(orderByPhone)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Điện thoại người đặt");
			return null;
		}
		if(KohanaUtils.isEmpty(orderByAddress)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Địa chỉ người đặt");
			return null;
		}
		
		if(!theSame && KohanaUtils.isEmpty(orderForName)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Tên người nhận");
			return null;
		}
		if(!theSame && KohanaUtils.isEmpty(orderForPhone)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Điện thoại người nhận");
			return null;
		}
		if(!theSame && KohanaUtils.isEmpty(orderForAddress)) {
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Địa chỉ người nhận");
			return null;
		}
		if(paymentCode.equals("TRF")) {
			if(KohanaUtils.isEmpty(bankName)) {
				BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Tên ngân hàng");
				return null;
			}
			if(KohanaUtils.isEmpty(bankAccountNumber)) {
				BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_MISSING_MANDATORY_FIELD + "Số tài khoản");
				return null;
			}
		}
		
		try {
			if(theSame) {
				getOrderService().createOrder(orderByName, orderByPhone, orderByAddress, 
						orderByName, orderByPhone, orderByAddress, 
						paymentCode, bankName, bankAccountNumber, items);
			} else {
				getOrderService().createOrder(orderByName, orderByPhone, orderByAddress, 
						orderForName, orderForPhone, orderForAddress, 
						paymentCode, bankName, bankAccountNumber, items);
			}
			if(clearCartAfterSubmit) {
				CartBean cartBean = (CartBean) BeanUtils.getContextBean("cartBean");
				cartBean.setItems(new ArrayList<CartItem>());
			}
			BeanUtils.getMessageBean().setMessage("Đơn đặt hàng của quý khách đã được gửi đi. Cảm ơn quý khách.");
		} catch (Exception ex) {
			logger.error(ex);
			BeanUtils.getMessageBean().setMessage(KohanaConstants.MSG_COMMON_ERROR);
			return null;
		}
		return KohanaConstants.PAGE_CLIENT_HOMEPAGE;
	}
	
	//getter setter
	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public int getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(int orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	public String getOrderByName() {
		return orderByName;
	}

	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}

	public String getOrderByPhone() {
		return orderByPhone;
	}

	public void setOrderByPhone(String orderByPhone) {
		this.orderByPhone = orderByPhone;
	}

	public String getOrderByAddress() {
		return orderByAddress;
	}

	public void setOrderByAddress(String orderByAddress) {
		this.orderByAddress = orderByAddress;
	}

	public String getOrderForName() {
		return orderForName;
	}

	public void setOrderForName(String orderForName) {
		this.orderForName = orderForName;
	}

	public String getOrderForPhone() {
		return orderForPhone;
	}

	public void setOrderForPhone(String orderForPhone) {
		this.orderForPhone = orderForPhone;
	}

	public String getOrderForAddress() {
		return orderForAddress;
	}

	public void setOrderForAddress(String orderForAddress) {
		this.orderForAddress = orderForAddress;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public boolean isTheSame() {
		return theSame;
	}

	public void setTheSame(boolean theSame) {
		this.theSame = theSame;
	}
	public boolean isClearCartAfterSubmit() {
		return clearCartAfterSubmit;
	}
	public void setClearCartAfterSubmit(boolean clearCartAfterSubmit) {
		this.clearCartAfterSubmit = clearCartAfterSubmit;
	}
	
}
