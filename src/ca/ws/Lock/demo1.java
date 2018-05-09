package ca.ws.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class demo1 {
	
	Lock lock = new ReentrantLock();

	@Test
	public void test1(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					share("zhangsan");
				}
			}
		}).start();
	
/*		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					share("Lisi");
				}			
			}
		}).start();*/
	
	}
	
	public void share(String name){
		//lock.lock();
		for(int i=0;i<10;i++)
			System.out.print(name + ".");					
		System.out.println("");
		//lock.unlock();
	}

}
