package ca.ws.eclipse;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Test;

/**
 * 
 * 增强for
 *
 */
public class demo4 {

	@Test
	public void test1(){
		int arr[] = {1,2,3};	
		for (int num : arr){
			System.out.println(num);
		}
	}

	@Test
	public void test2(){
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for (Object obj : list){
			int i = (Integer)obj;
			System.out.println(i);
		}
	}
	
	@Test
	public void test3(){
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		//传统方式1
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String value = (String) map.get(key);
			System.out.println(key + "=" + value);
		}
	}
	
	@Test
	public void test4(){
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		//传统方式2
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Entry) it.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	

	@Test
	public void test5(){
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		
		//增强for 1， 取map得第一种
		for(Object obj : map.keySet()){
			String key = (String)obj;
			String value = (String) map.get(key);
			System.out.println(key + "=" + value);
		}
	}
	
	@Test
	public void test6(){
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");

		//增强for 2， 取map得第2种
		for(Object entry : map.entrySet()){
			System.out.println(((Entry) entry).getKey() + "=" + ((Entry) entry).getValue());	
		}
	}
	

	//使用增强for 需要注意的问题
	@Test
	public void test7(){
		 int arr[] = {1,2,3};
		 for(int i : arr){
			 i = 10;
		 }
		 System.out.println(arr[0]);
		 System.out.println(arr[1]);
		 System.out.println(arr[2]);
		 
		 List list = new ArrayList();
		 list.add("1");
		 
		 for(Object obj : list){
			 obj = "10";
		 }
		 System.out.println(list.get(0));
	}


}
