package ca.ws.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class demo2 {
	
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//��ͳ
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
		
		//��ǿfor
		for(String s : list){
			System.out.println(s);
		}
	}
	

	@Test
	public void test2(){
		
		Map<Integer, String> map = new HashMap();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		//��ͳ keyset, entryset
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while (it.hasNext()){
			Map.Entry<Integer, String> item = it.next();
			System.out.println(item.getKey() + " : "+ item.getValue());
		}
		
		//��ǿfor
		for(Map.Entry<Integer,String> entry : map.entrySet()){
			System.out.print(entry.getKey() + " : ");
			System.out.println(entry.getValue());
		}
	 
	}
	

	@Test
	public void test3(){
		//�÷���ʱ�����߱���һ��

		//ArrayList<Object> list = new ArrayList<String>();
		//ArrayList<String> list = new ArrayList<Object>();
		
		//���Ǽ��ݣ�����
		ArrayList<String> list = new ArrayList();
		
		ArrayList list1 = new ArrayList<String>();

		
	}

}
