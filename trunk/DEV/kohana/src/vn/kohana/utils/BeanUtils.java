package vn.kohana.utils;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import vn.kohana.bean.BaseBean;

//TODO refine it
public class BeanUtils {
	private static Logger logger = Logger.getLogger(BeanUtils.class);
	
	private static ResourceBundle config = ResourceBundle.getBundle("configurations");
	
	public static BaseBean getContextBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (BaseBean) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", BaseBean.class);
	}
	
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request;
	}
	
	public static String getConfig(String key) {
		if(!KohanaUtils.isEmpty(key)) {
			return config.getString(key);
		}
		return "";
	}
}