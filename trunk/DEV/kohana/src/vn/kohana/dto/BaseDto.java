package vn.kohana.dto;

import java.io.Serializable;

public abstract class BaseDto implements Serializable, Cloneable {
	private Integer id;
	
	//transient fields
	private boolean selectedInDataTable;

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	//getters setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isSelectedInDataTable() {
		return selectedInDataTable;
	}

	public void setSelectedInDataTable(boolean selectedInDataTable) {
		this.selectedInDataTable = selectedInDataTable;
	}
}
