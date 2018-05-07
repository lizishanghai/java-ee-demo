package ca.ws.thread;

import org.junit.Test;

/**
 * 创建线程的第二种方法：实现Runnable接口
 * 
 * 1.定义类实现runnable接口
 * 2.覆盖runnable接口中的run方法
 * 3.通过Thread类建立线程对象
 * 4.将runnable接口的子类对象作为实际参数传递给thread类的构造函数
 * 5.调用thread类的start方法开启线程并调用runnable接口子类的run 方法
 * 
 * 实现方式和继承方式有什么区别：
 * 继承方式，不能继承其他类，实现方式避免了但继承的局限性。
 * 建议使用实现方式
 * 
 * 继承thread：线程代码存放thread子类run方法中
 * 实现runnable：线程代码存放在接口的子类run方法中
 */
public class demo2 implements Runnable{
	
	private int tick = 500;

	/**
	 * 
	 * 多线程的安全问题
	 * 
	 * 问题原因：
	 * 	共享数据被多个线程同时操作
	 * 
	 * 解决办法：
	 * 	对多条操作共享数据的语句，只能让一个线程全部执行完。
	 * 
	 * java 对多线程的安全问题提供了专业的解决方式
	 * 	同步代码块
	 * 
	 * Synchronized（对象）
	 * {
	 * 	需要被同步的代码
	 * }
	 * 对象如同锁，持有锁的线程可以在同步中执行
	 * 没有持有锁的线程即使获取cpu的执行权，也进不去，因为没有获取锁
	 * 
	 * 同步的前提：
	 * 	必须两个以上线程
	 *  必须多个线程使用同一个锁
	 *  
	 * 好处：解决多线程安全问题
	 * 坏处：多个线程需要判断锁，较为消耗资源
	 */
	public void run(){
		while(true){
			if(tick>0){
				//try {Thread.sleep(1);} catch (InterruptedException e) {}
				
				synchronized(new Object()){
					System.out.println(Thread.currentThread().getName() + " sales ... " + tick--);					
				}
			}
			
		}
		
	}
}
