package ca.ws.sharedata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

public class demo1 {
	
	private static int data;
	private static Map<Thread,Integer> threadMap = new HashMap<Thread,Integer>();

	@Test
	public void test1(){
		for(int i =0;i<5;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					data = new Random().nextInt();
					System.out.println("   ");
					System.out.println(Thread.currentThread().getName() + " has put data: " + data);
					threadMap.put(Thread.currentThread(), data);
					Aget();
					Bget();
					
				}
				
			}).start();

		}
	}

	public void Aget(){
		int data = threadMap.get(Thread.currentThread());
		System.out.println("A from "+ Thread.currentThread().getName()
				+ " get data "+ data);
		
	}

	public void Bget(){
		int data = threadMap.get(Thread.currentThread());
		System.out.println("B from "+ Thread.currentThread().getName()
				+ " get data "+ data);
		
	}

}
