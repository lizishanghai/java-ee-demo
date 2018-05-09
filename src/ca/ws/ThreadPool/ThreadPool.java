package ca.ws.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPool {
	@Test
	public void test1(){
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
//		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		for(int i=0;i<10;i++){
			int task = i;
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for(int j=0;j<10;j++){
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of "+ task);				
					}
					
				}
				
			});
		}
	//	threadPool.shutdown();
		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
				new Runnable(){
					@Override
					public void run() {
						
						System.out.println("bombing");
				}},
				5,
				2,
				TimeUnit.SECONDS);
		System.out.println("10 tasks have been commited");
	}
}
