package com.jun.xiaoquren.util;

import com.jun.xiaoquren.exception.InvalidParamException;

public class HttpParamUtil {
	
	private static final String columnRegex = "[a-zA-Z0-9_]+";
	
	public static Integer getIntByString(String param) throws InvalidParamException {
		if (!StringUtil.isEmpty(param)) {
			return Integer.valueOf(param);
		}
		throw new InvalidParamException("param[" + param + "] is invalid.");
	}
	
	public static String getSortColumnNmae(String sidx) throws InvalidParamException {
		if (!StringUtil.isEmpty(sidx) && sidx.matches(columnRegex)) {
			return sidx.trim();
		}
		throw new InvalidParamException("sidx[" + sidx + "] is invalid.");
	}
	
	public static String getSortDesc(String sort) throws InvalidParamException {
		if (!StringUtil.isEmpty(sort) && (sort.equalsIgnoreCase("asc") || sort.equalsIgnoreCase("desc"))) {
			return sort.trim();
		}
		throw new InvalidParamException("sort[" + sort + "] is invalid.");
	}

}
