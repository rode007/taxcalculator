package com.what21.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class T {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List l=new ArrayList();
		Map map=new HashMap();	
		map.put("qq", 11);
		map.put("qq1", 22);
		l.add(map);
		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			Map<String, Object> map11=(Map<String, Object>) l.get(i);
			System.out.println(map11);
		}
	}
}
