package vn.kohana.criteria;

import java.io.Serializable;

public abstract class BaseCriteria implements Serializable, Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private Integer id;
	private PagingCriterion pagingCriterion;
	private boolean forCounting;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PagingCriterion getPagingCriterion() {
		return pagingCriterion;
	}

	public void setPagingCriterion(PagingCriterion pagingCriterion) {
		this.pagingCriterion = pagingCriterion;
	}

	public boolean isForCounting() {
		return forCounting;
	}

	public void setForCounting(boolean forCounting) {
		this.forCounting = forCounting;
	}
}
