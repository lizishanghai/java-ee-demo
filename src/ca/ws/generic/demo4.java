package ca.ws.generic;

import org.junit.Test;

//自定义类上的泛型
public class demo4<T,E,K> {
	
	@Test
	public void testa(){
		//a((T) "aaa");
	}
	
	public T a(T t){
		return t;
	}
	
	public void b(T t, E e, K k){
		
	}
	
	public static <T> void c(T t){
		
	}

}
