package ca.ws.enumeration;

import org.junit.Test;

//ö����
public class demo1 {
	
	@Test
	public void test(){
		print(Grade.B);
	}
	 
	public void print(Grade g){ //A B C D E
		String value = g.getValue();
		System.out.println(value);
	}

}
/*
class Grade{
	private Grade(){}
	public static final Grade A = new Grade();
	public static final Grade B = new Grade();
	public static final Grade C = new Grade();
	public static final Grade D = new Grade();
	public static final Grade E = new Grade();
	
}*/

//��ζ���ö�ٵĹ��캯�����������ֶΣ�ȥ��װ�������Ϣ
enum Grade{	//class		A 100-90 	B 89-80	...
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0"); 	//Object 
	
	private String value;	//��װÿ�������Ӧ�ķ���
	private Grade(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
