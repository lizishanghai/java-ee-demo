package ca.ws.generic;

public class demo5 {
	
	//��дһ�����ͷ���, ʵ��ָ��λ���ϵ�����Ԫ�صĽ���
	public <T> void swap(T arr[], int p1, int p2){
		
		T temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}
	

	//��дһ�����ͷ���, ����һ���������飬���ߵ������е�����Ԫ��
	public <T> void reverse(T arr[]){
		
		for(int i=0,j=arr.length-1;i<j;i++,j--){

			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
