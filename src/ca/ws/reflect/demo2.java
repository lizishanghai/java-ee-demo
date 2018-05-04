package ca.ws.reflect;

import java.util.List;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Test;

//解剖类的构造函数，创建类的对象
public class demo2 {
	
	//反射构造函数 ：public Person()
	@Test
	public void test1() throws Exception{
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		
		System.out.println(p.name);
	}

	//反射构造函数 ：public Person(String name)
	@Test
	public void test2() throws Exception{
		
		String name = "abcde";
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance(name);	
		
	}
	
	//反射构造函数 ：public Person(String name, int password)
	@Test
	public void test3() throws Exception{
		
		String name = "abcde";
		int password = 123;
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(String.class, int.class);
		Person p = (Person) c.newInstance(name, password);
		
	}

	//反射构造函数 ：public Person(List list)
	@Test
	public void test4() throws Exception{
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);
		Person p = (Person) c.newInstance(new ArrayList());
		
		System.out.println(p.name);
		
	}

	//创建对象的另外一种途径。等效于test1
	@Test
	public void test5() throws Exception{
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Person p = (Person) clazz.newInstance(); //必须要有无参构造函数
		System.out.println(p);		
	}
 

	
}
