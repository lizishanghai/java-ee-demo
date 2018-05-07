package ca.ws.thread;

import org.junit.Test;

public class testDemo {

	@Test
	public void test1(){
		demo1 d1 = new demo1("One");
		demo1 d2 = new demo1("Two");
		d1.start();		
		d2.start();		
		
		for(int i =0;i<60;i++){
			System.out.println("Main!---" +i);
		}
	}
	

	@Test
	public void test2(){
		demo2 d2 = new demo2();
		
		Thread t1 = new Thread(d2);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d2);
		Thread t4 = new Thread(d2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
//		
//		for(int i =0;i<60;i++){
//			System.out.println("Main!---" +i);
//		}
	}
}
