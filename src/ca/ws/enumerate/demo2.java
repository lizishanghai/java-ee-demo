package ca.ws.enumerate;

import org.junit.Test;

//ö����
public class demo2 {
	
	@Test
	public void test(){
		print(Grade2.D);
	}
	 
	public void print(Grade2 g){ //A B C D E
		String value = g.localValue();
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

//�����󷽷���ö��
enum Grade2{	//class		A 100-90  ��	B 89-80  ��	...
	A("100-90"){
		public String localValue(){
			return "��";
		}
	}
	
	,B("89-80"){
		public String localValue(){
			return "��";
		}
	}
	
	,C("79-70"){
		public String localValue(){
			return "��";
		}
	}
	
	,D("69-60"){
		public String localValue(){
			return "��";
		}
	}
	
	,E("59-0"){
		public String localValue(){
			return "��";
		}
	}
	; 	//Object 
	
	private String value;	//��װÿ�������Ӧ�ķ���
	private Grade2(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract String localValue();
}
