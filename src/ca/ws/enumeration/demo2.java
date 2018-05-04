package ca.ws.enumeration;

import org.junit.Test;

//枚举类
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

//带抽象方法的枚举
enum Grade2{	//class		A 100-90  优	B 89-80  良	...
	A("100-90"){
		public String localValue(){
			return "优";
		}
	}
	
	,B("89-80"){
		public String localValue(){
			return "优";
		}
	}
	
	,C("79-70"){
		public String localValue(){
			return "优";
		}
	}
	
	,D("69-60"){
		public String localValue(){
			return "优";
		}
	}
	
	,E("59-0"){
		public String localValue(){
			return "优";
		}
	}
	; 	//Object 
	
	private String value;	//封装每个对象对应的分数
	private Grade2(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract String localValue();
}
