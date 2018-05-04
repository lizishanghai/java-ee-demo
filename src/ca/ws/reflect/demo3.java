package ca.ws.reflect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.junit.Test;

//反射类的方法
public class demo3 {
	
	//反射类的方法 	public void aa1()
	@Test
	public void test1() throws Exception{
		
		Person p = new Person();
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Method method = clazz.getMethod("aa1", null);
		method.invoke(p, null);
	}
	

	//反射类的方法 	public void aa1(String name, int password){
	@Test
	public void test2() throws Exception{
		
		Person p = new Person();
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class, int.class);
		method.invoke(p, "string", 123);
	}

	//反射类的方法 	public Class[] aa1(String name, int[] password){
	@Test
	public void test3() throws Exception{
		
		Person p = new Person();
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class, int[].class);
		Class cs[] = (Class[]) method.invoke(p, "string", new int[]{1,2,3,4});
		System.out.println(cs[0]);
	}

	//反射类的方法 	private void aa1(InputStream in){
	@Test
	public void test4() throws Exception{
		
		Person p = new Person();
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Method method = clazz.getDeclaredMethod("aa1", InputStream.class);//private
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("c:\\eula.3082.txt"));
	}


	//反射类的方法 	public static void aa1(int num){
	@Test
	public void test5() throws Exception{
		
		Person p = new Person();
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Method method = clazz.getMethod("aa1", int.class);
		method.invoke(null, 2345);//static
	}
	
}
