package ca.ws.reflect;

import java.util.List;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Test;

//������Ĺ��캯����������Ķ���
public class demo2 {
	
	//���乹�캯�� ��public Person()
	@Test
	public void test1() throws Exception{
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		
		System.out.println(p.name);
	}

	//���乹�캯�� ��public Person(String name)
	@Test
	public void test2() throws Exception{
		
		String name = "abcde";
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance(name);	
		
	}
	
	//���乹�캯�� ��public Person(String name, int password)
	@Test
	public void test3() throws Exception{
		
		String name = "abcde";
		int password = 123;
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getConstructor(String.class, int.class);
		Person p = (Person) c.newInstance(name, password);
		
	}

	//���乹�캯�� ��public Person(List list)
	@Test
	public void test4() throws Exception{
		
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Constructor c = clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);
		Person p = (Person) c.newInstance(new ArrayList());
		
		System.out.println(p.name);
		
	}

	//�������������һ��;������Ч��test1
	@Test
	public void test5() throws Exception{
		Class clazz = Class.forName("ca.ws.reflect.Person");
		Person p = (Person) clazz.newInstance(); //����Ҫ���޲ι��캯��
		System.out.println(p);		
	}
 

	
}
