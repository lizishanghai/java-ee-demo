package ca.ws.notify;

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
		}).start();;
		
		for(int i=0;i<10;i++){
			business.main(i);
					
		}
		
	}

}

class Business {
	private boolean bShouldSub = true;
	public synchronized void sub(int j){
		if(!bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		for(int i =0;i<10;i++)
			System.out.println("sub thread run ... "+i +" of "+ j);
		bShouldSub = false;
		this.notify();
	}
	
	public synchronized void main(int j){
		if(bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		for(int i=0;i<100;i++)
			System.out.println("main thread run ... "+i+" of "+ j);
		bShouldSub = true;
		this.notify();
		
	}
}
