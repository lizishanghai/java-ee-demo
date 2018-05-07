package ca.ws.thread;

import org.junit.Test;


/**
 * 创建线程的第一种方法：继承Thread
 */
public class demo1 extends Thread{
	
	private String name;
	
	demo1(String name){
		this.name = name;
	}
	//创建线程
	public void run(){
		for(int i =0;i<60;i++){
			System.out.println(name +" thread run!---" +i);
		}
	}
}
