package ca.ws.thread;

import org.junit.Test;


/**
 * �����̵߳ĵ�һ�ַ������̳�Thread
 */
public class demo1 extends Thread{
	
	private String name;
	
	demo1(String name){
		this.name = name;
	}
	//�����߳�
	public void run(){
		for(int i =0;i<60;i++){
			System.out.println(name +" thread run!---" +i);
		}
	}
}
