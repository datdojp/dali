package vn.kohana.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn.kohana.dto.BaseDto;
import vn.kohana.dto.ProductDto;
import vn.kohana.mst.CategoryMst;

//TODO refine it
public class KohanaUtils {
	//VALIDATOR
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
	public static boolean isEmpty(List list) {
		return list == null || list.size() == 0;
	}
	public static boolean isValidId(Integer id) {
		return id != null && id > 0;
	}
	public static boolean isEmpty(Object[] arr) {
		return arr == null || arr.length == 0;
	}
	
	public static String getImageFilename(Object dto) {
		if(dto == null) {
			String result = "";
			if(dto instanceof CategoryMst) {
				result = "cat" + ((CategoryMst) dto).getCode();
			} else if(dto instanceof ProductDto) {
				result = "prd" + ((ProductDto) dto).getId();
			}
		}
		return null;
	}
	
	public static String getFileExtension(String filename) {
		if(isEmpty(filename)) {
			return "";
		}
		if(filename.indexOf(".") < 0 || filename.endsWith(".")) {
			return "";
		}
		return filename.substring(filename.lastIndexOf(".") + 1);
	}
	
	public static BaseDto getDtoFromList(Integer id, List list) {
		if(KohanaUtils.isEmpty(list) || id == null) {
			return null;
		}
		
		List<BaseDto> listDto = list;
		for(BaseDto aDto : listDto) {
			if(id.equals(aDto.getId())) {
				return aDto;//found
			}
		}
		return null;//not found
	}
	
	public static int getDtoIndex(Integer id, List list) {
		if(KohanaUtils.isEmpty(list)) {
			return -1;
		}
		int i = 0;
		List<BaseDto> listDto = list;
		for(BaseDto aDto : listDto) {
			if(id.equals(aDto.getId())) {
				return i; 
			}
			i++;
		}
		return -1;
	}
	
	public static int getDtoIndex(BaseDto dto, List list) {
		if(dto == null) {
			return -1;
		} else {
			return getDtoIndex(dto.getId(), list);
		}
	}
	public static List getSelectedObjects(List list) {
		List results = new ArrayList();
		if(!KohanaUtils.isEmpty(list)) {
			List<BaseDto> listDto = list;
			for(BaseDto aDto : listDto) {
				if(aDto.isSelectedInDataTable()) {
					results.add(aDto);
				}
			}
		}
		return results;
	}
	
	public static List<Integer> getSelectedIds(List list) {
		List<Integer> results = new ArrayList<Integer>();
		if(!KohanaUtils.isEmpty(list)) {
			List<BaseDto> listDto = list;
			for(BaseDto aDto : listDto) {
				if(aDto.isSelectedInDataTable()) {
					results.add(aDto.getId());
				}
			}
		}
		return results;
	}
	
	public static Boolean stringToBoolean(String value, String nullCase, String trueCase, String falseCase) {
		if(StringUtils.equals(value, nullCase)) {
			return null;
		}
		if(StringUtils.equals(value, trueCase)) {
			return Boolean.TRUE;
		}
		if(StringUtils.equals(value, falseCase)) {
			return Boolean.FALSE;
		}
		return null;
	}
}
