package ca.ws.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class demo1 {
	
	@Test
	public void test1(){
		final Business business = new Business();
		
		new Thread(
				new Runnable(){
					@Override
					public void run() {
						for(int i=0;i<10;i++)
							business.sub(i);
					}
		}).start();
		
		for(int i=0;i<10;i++){
			business.main(i);
					
		}
		
	}

}

class Business {
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	private boolean bShouldSub = true;
	
	public  void sub(int j){
		lock.lock();
		try{
			while(!bShouldSub){
				try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			for(int i =0;i<10;i++)
				System.out.println("sub thread run ... "+i +" of "+ j);
			bShouldSub = false;
			condition.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public  void main(int j){
		lock.lock();
		try{
			while(bShouldSub){
				try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			for(int i=0;i<100;i++)
				System.out.println("main thread run ... "+i+" of "+ j);
			bShouldSub = true;
			condition.signal();
			
		}finally{
			lock.unlock();
		}

	}
}
