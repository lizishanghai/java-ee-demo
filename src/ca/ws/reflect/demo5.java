package ca.ws.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//�����ֶ�
public class demo5 {
	
	//�����ֶΣ�public String name = "aaa";
	@Test
	public void test1() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Field f = clazz.getField("name");

		//��ȡ�ֶε�ֵ
		Object obj = f.get(p);
		//��ȡ�ֶε�����
		Class cls = f.getType();
		
		if(cls.equals(String.class)){
			String svalue = (String)obj;
			System.out.println(svalue);			
		}
		
		//�����ֶε�ֵ
		f.set(p, "xxxxxxx");
		System.out.println(p.name);
	}
	
	//�����ֶ� 		private int password;
	@Test
	public void test2() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");

		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}

	//�����ֶ� 		private static int age = 23;
	@Test
	public void test3() throws Exception{
	
		Person p = new Person();		
		Class clazz = Class.forName("ca.ws.reflect.Person");

		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}

}
