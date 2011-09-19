package vn.kohana.mst;

import java.io.Serializable;

public abstract class BaseMst implements Serializable {
	protected String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
