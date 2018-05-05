package ca.ws.generic;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
	
	public void test1(){
		
		List list = new ArrayList();
		list.add("aaa");
		//Integer i = (Integer) list.get(0);		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("aaa");
		String s = list1.get(0);
	}
	

}
