package ca.ws.generic;

import org.junit.Test;

//�Զ�������͵ķ���
public class demo3 {
	
	@Test
	public void testa(){
		a("aaa");
		a(123);
	}
	
	public <T> T a(T t){
		return t;
	}
	
	public <T,E,K> void b(T t, E e, K k){
		
	}

}
