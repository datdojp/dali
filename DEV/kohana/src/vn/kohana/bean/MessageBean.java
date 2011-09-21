package vn.kohana.bean;

public class MessageBean extends BaseBean {
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		String temp = message;
		message = null;
		return temp;
	}
}
