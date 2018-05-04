package test.ca.ws.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.ws.basics.Person;

//personµÄ²âÊÔÀà
public class testPerson {
	
	private Person p;
	
	@Before
	public void before(){
		p = new Person();
		System.out.println("Before test!!");
	}
	
	@Test
	public void testRun(){
//		Person p = new Person();
		p.run();
	}

	@Test
	public void testEat(){
//		Person p = new Person();
		p.eat();
	}
	
	@After
	public void after(){
		p = null;
		System.out.println("After test!!");
	}
	
}
