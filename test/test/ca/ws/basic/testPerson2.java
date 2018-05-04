package test.ca.ws.basic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.ws.basics.Person;

//person�Ĳ�����
public class testPerson2 {
		
	@BeforeClass
	public static void before(){
		System.out.println("Before class!!");
	}
	
	@Test
	public void testRun(){
		Person p = new Person();
		p.run();
	//	Assert.assertEquals("1", p.run());
	}

	@Test
	public void testEat(){
		Person p = new Person();
		p.eat();
	}
	
	@AfterClass
	public static void after(){

		System.out.println("After class!!");
	}
	
}
