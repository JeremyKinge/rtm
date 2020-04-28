package com.kingge.rtm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

public class JSON {

	public static void main(String[] args) throws Exception {

	}
	
	public static String encode(Object obj) {
		return com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
	}
	
	//dateFormat  "yyyy-MM-dd HH:mm:ss"
	public static String encode(Object obj,String dateFormat) {
		if(dateFormat==null)
			return com.alibaba.fastjson.JSON.toJSONString(obj);
		return com.alibaba.fastjson.JSON.toJSONStringWithDateFormat(obj, dateFormat);
	}

	public static <T> List<T> decodeArray(String jsonString, Class<T> clazz) {
		if (Util.isNullOrEmpty(jsonString)) return null;
		List listin= com.alibaba.fastjson.JSON.parseArray(jsonString);
		List<T> listout=new ArrayList<>();
		for (int i = 0; i < listin.size(); i++) {
			T entity=decode(JSON.encode(listin.get(i)),clazz);
			listout.add(entity);
		}
		return listout;
//		return com.alibaba.fastjson.JSON.parseArray(jsonString,clazz);//,Feature.DisableFieldSmartMatch
	}

	public static  <T> T decode(String jsonString, Class<T> clazz) {
		if (Util.isNullOrEmpty(jsonString)) return null;
		return com.alibaba.fastjson.JSON.parseObject(jsonString,clazz,Feature.DisableFieldSmartMatch);
	}
	//new TypeReference<Result<User>>(){}
	public static  <T> T decode(String jsonString, TypeReference<T> typeReference) {
		if (Util.isNullOrEmpty(jsonString)) return null;
		return com.alibaba.fastjson.JSON.parseObject(jsonString,typeReference,Feature.DisableFieldSmartMatch);
	}

	public static  <T> T decode(Map obj, Class<T> clazz) {
		if (obj==null) return null;
		return com.alibaba.fastjson.JSON.parseObject(encode(obj),clazz,Feature.DisableFieldSmartMatch);
	}
	
	public static Object decode(String jsonString)   {
		if (Util.isNullOrEmpty(jsonString)) return null;
		return com.alibaba.fastjson.JSON.parseObject(jsonString,Feature.DisableFieldSmartMatch);
	}
	
	//=================================
	public static String getErrMes(String mes) {
		Map map=new HashMap();
		map.put("isOk", "1");
		map.put("mes", mes);
		return JSON.encode(map);
	}
	public static String getErrMes(String mes,String errCode) {
		Map map=new HashMap();
		map.put("isOk", errCode);
		map.put("mes", mes);
		return JSON.encode(map);
	}
	public static String getOKMes(String mes) {
		Map map=new HashMap();
		map.put("isOk", "0");
		map.put("mes", mes);
		return JSON.encode(map);
	}
	public static Map getOKMap() {
		Map map=new HashMap();
		map.put("isOk", "0");
		return map;
	}
	public static Map getErrMap(String errNumber,String mes) {
		Map map=new HashMap();
		map.put("isOk", errNumber);
		map.put("mes", mes);
		return map;
	}
}







