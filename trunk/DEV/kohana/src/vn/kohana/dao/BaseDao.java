package vn.kohana.dao;

import java.io.Serializable;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import vn.kohana.utils.KohanaUtils;

public abstract class BaseDao extends SqlMapClientDaoSupport implements Serializable, Cloneable {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	protected String getSQLSearchableString(String input) {
		if(KohanaUtils.isEmpty(input)) {
			return "%";
		}
		return "%" + getSearchableString(input) + "%";
	}
	
	private static final String ALL_VIETNAMESE_CHARACTERS =
		"ĂÂÁÀẢÃẠẮẰẲẴẶẤẦẨẪẬ" +
		"ăâáàảãạắằẳẵặấầẩẫậ" +
		"ƠÔÓÒỎÕỌỚỜỞỠỢỐỒỔỖỘ" +
		"ơôóòỏõọớờởỡợốồổỗộ" +
		"ƯÚÙỦŨỤỨỪỬỮỰ" +
		"ưúùủũụứừửữự" + 
		"ÍÌỈĨỊ" +
		"íìỉĩị" +
		"ÊÉÈẺẼẸẾỀỂỄỆ" +
		"êéèẻẽẹếềểễệ" +
		"ÝỲỶỸỴ" +
		"ýỳỷỹỵ" +
		"Đ" +
		"đ";
	private static final String ALL_VIETNAMESE_CHARACTERS_WITHOUT_SIGN =
		"AAAAAAAAAAAAAAAAA" +
		"aaaaaaaaaaaaaaaaa" +
		"OOOOOOOOOOOOOOOOO" +
		"ooooooooooooooooo" +
		"UUUUUUUUUUU" +
		"uuuuuuuuuuu" + 
		"IIIII" +
		"iiiii" +
		"EEEEEEEEEEE" +
		"eeeeeeeeeee" +
		"YYYYY" +
		"yyyyy" +
		"D" +
		"d";

	protected String getSearchableString(String input) {
		if(KohanaUtils.isEmpty(input)) {
			return input;
		}
		int length = input.length();
		String result = "";
		for(int i = 0; i < length; i++) {
			String aChar = input.substring(i, i+1);
			int idx = ALL_VIETNAMESE_CHARACTERS.indexOf(aChar);
			if(idx >= 0) {
				aChar = ALL_VIETNAMESE_CHARACTERS_WITHOUT_SIGN.substring(idx, idx + 1);
			}
			result = result + aChar;
		}
		return result.toLowerCase();
	}
	
	public Integer getLastInsertId() {
		return (Integer) getSqlMapClientTemplate().queryForObject("getLastInsertId");
	}
}
