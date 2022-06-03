package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {
	
	public void ex1() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "장길동");
		map.put(5, "박길동");
		
		System.out.println(map);
		
	}
	
	public void ex2() {
		
		Member mem = new Member();
		
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
		
		System.out.println("\n======================");
		
		//map
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25);
		
		System.out.println(map.get("id"));
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));
	
		Set<String> set = map.keySet(); 
		
		System.out.println(set);//id pw age
		
		System.out.println(map.get(set));//null
		
		for(String e : set) {
			System.out.println(map.get(e));
		}

	}
	
	public void ex3() {
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<10;i++) {
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("id", "user0"+i);
			map.put("pw", "pass0"+i);
			
			list.add(map);
			
		}

		for(Map<String,Object> temp : list) {
			System.out.println(temp.get("id"));
		}
		
	}
	
	
	

}
