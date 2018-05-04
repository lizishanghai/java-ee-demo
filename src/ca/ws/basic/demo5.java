package ca.ws.basic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//可变参数
public class demo5 {

	@Test
	public void testSum(){
		sum(1,2,3,4,5,6);
	}
	
	//可变参数，可以看成数组
	public void sum(int ...nums){
		int sum = 0;
		for (int i :nums){
			sum += i;
		}
		System.out.println(sum);
	}
	
	//可变参数需要注意的问题
	//不行：public void aa(int ...nums, int x){
	public void aa(int x, int ...nums){
		
	}
	
	@Test
	public void bb(){
		List list = Arrays.asList("1", "2", "3");
		System.out.println(list);
		
		String arr[] = {"1","2","3","4"};
		list = Arrays.asList(arr);
		System.out.println(list);
		
		int nums[] = {1,2,3,4,5}; //这个细节一定要小心
		list = Arrays.asList(nums);
		System.out.println(list);
		
	}
}
