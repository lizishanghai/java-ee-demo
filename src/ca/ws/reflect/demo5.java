package ca.ws.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//反射字段
public class demo5 {
	
	//反射字段：public String name = "aaa";
	@Test
	public void test1() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Field f = clazz.getField("name");

		//获取字段的值
		Object obj = f.get(p);
		//获取字段的类型
		Class cls = f.getType();
		
		if(cls.equals(String.class)){
			String svalue = (String)obj;
			System.out.println(svalue);			
		}
		
		//设置字段的值
		f.set(p, "xxxxxxx");
		System.out.println(p.name);
	}
	
	//反射字段 		private int password;
	@Test
	public void test2() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");

		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}

	//反射字段 		private static int age = 23;
	@Test
	public void test3() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");

		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}

}
