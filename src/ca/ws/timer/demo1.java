package ca.ws.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class demo1 {
	
	private static int count =0;
	
	@Test
	public void test1() throws InterruptedException{
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("bombing");	
			}
		}, 1000,3000);
		while(true){
			System.out.println(new Date().getSeconds());
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		

		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				count = (count+1)%2;
				System.out.println("bombing");	
			}
		}, 2000+2000*count);
		
		
		while(true){
			System.out.println(new Date().getSeconds());
			Thread.sleep(1000);
		}
	}

}
