package ca.ws.reflect;

public class demo1 {

	/**
	 * 反射：加载类,获得类的字节码
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		//1.
		Class clazz = Class.forName("ca.ws.reflect.Person");
		
		//2.
		Class clazz1 = new Person().getClass();
		
		//3.
		Class clazz2 = Person.class;
		
	}

}
