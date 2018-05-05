package ca.ws.generic;

import org.junit.Test;

//自定义带泛型的方法
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
