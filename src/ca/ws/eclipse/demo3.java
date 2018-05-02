package ca.ws.eclipse;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//自动装箱 拆箱
public class demo3 {
	public static void main(String[] args) {
		
		//1.5 jvm
		Integer i = 1;	//装箱
		int j = i;	//拆箱
		
		//典型应用
		List list = new ArrayList();
		list.add(1);	//自动装箱
		list.add(2);
		list.add(3);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			int k = (Integer)it.next();	//自动拆箱
		}
		
 	}


}
