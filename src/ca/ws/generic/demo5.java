package ca.ws.generic;

public class demo5 {
	
	//编写一个泛型方法, 实现指定位置上的数组元素的交换
	public <T> void swap(T arr[], int p1, int p2){
		
		T temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}
	

	//编写一个泛型方法, 接受一个任意数组，并颠倒数组中的所有元素
	public <T> void reverse(T arr[]){
		
		for(int i=0,j=arr.length-1;i<j;i++,j--){

			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
