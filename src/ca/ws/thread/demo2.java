package ca.ws.thread;

import org.junit.Test;

/**
 * �����̵߳ĵڶ��ַ�����ʵ��Runnable�ӿ�
 * 
 * 1.������ʵ��runnable�ӿ�
 * 2.����runnable�ӿ��е�run����
 * 3.ͨ��Thread�ཨ���̶߳���
 * 4.��runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�thread��Ĺ��캯��
 * 5.����thread���start���������̲߳�����runnable�ӿ������run ����
 * 
 * ʵ�ַ�ʽ�ͼ̳з�ʽ��ʲô����
 * �̳з�ʽ�����ܼ̳������࣬ʵ�ַ�ʽ�����˵��̳еľ����ԡ�
 * ����ʹ��ʵ�ַ�ʽ
 * 
 * �̳�thread���̴߳�����thread����run������
 * ʵ��runnable���̴߳������ڽӿڵ�����run������
 */
public class demo2 implements Runnable{
	
	private int tick = 500;

	/**
	 * 
	 * ���̵߳İ�ȫ����
	 * 
	 * ����ԭ��
	 * 	�������ݱ�����߳�ͬʱ����
	 * 
	 * ����취��
	 * 	�Զ��������������ݵ���䣬ֻ����һ���߳�ȫ��ִ���ꡣ
	 * 
	 * java �Զ��̵߳İ�ȫ�����ṩ��רҵ�Ľ����ʽ
	 * 	ͬ�������
	 * 
	 * Synchronized������
	 * {
	 * 	��Ҫ��ͬ���Ĵ���
	 * }
	 * ������ͬ�������������߳̿�����ͬ����ִ��
	 * û�г��������̼߳�ʹ��ȡcpu��ִ��Ȩ��Ҳ����ȥ����Ϊû�л�ȡ��
	 * 
	 * ͬ����ǰ�᣺
	 * 	�������������߳�
	 *  �������߳�ʹ��ͬһ����
	 *  
	 * �ô���������̰߳�ȫ����
	 * ����������߳���Ҫ�ж�������Ϊ������Դ
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
