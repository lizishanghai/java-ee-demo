package ca.ws.condition;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class demo2 {
	
	@Test
	public void test1(){
		final Business2 business = new Business2();
		
		new Thread(
				new Runnable(){
					@Override
					public void run() {
						for(int i=0;i<10;i++)
							business.sub(i);
					}
		}).start();
				
		new Thread(
				new Runnable(){
					@Override
					public void run() {
						for(int i=0;i<10;i++)
							business.sub2(i);
					}
		}).start();
		
		for(int i=0;i<10;i++){
			business.main(i);
					
		}
		
	}

}

class Business2 {
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	private int shouldSub = 1;
	
	public  void sub(int j){
		lock.lock();
		try{
			while(shouldSub != 1){
				try {
					condition1.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			for(int i =0;i<10;i++)
				System.out.println("sub thread run ... "+i +" of "+ j);
			shouldSub = 2;
			condition2.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public  void sub2(int j){
		lock.lock();
		try{
			while(shouldSub != 2){
				try {
					condition2.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			for(int i =0;i<10;i++)
				System.out.println("sub 2 thread run ... "+i +" of "+ j);
			shouldSub = 3;
			condition3.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public  void main(int j){
		lock.lock();
		try{
			while(shouldSub != 3){
				try {
					condition3.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			for(int i=0;i<100;i++)
				System.out.println("main thread run ... "+i+" of "+ j);
			shouldSub = 1;
			condition1.signal();
			
		}finally{
			lock.unlock();
		}

	}
}
