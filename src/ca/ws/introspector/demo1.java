package ca.ws.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//ʹ����ʡapi����bean������
public class demo1 {
	
	//�õ�bean����������
	@Test
	public void test1() throws IntrospectionException{

		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);//�õ�bean�Լ�������
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}

	//����bean��ָ������: age
	@Test
	public void test2() throws Exception{

		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		
		//�õ����Ե�д������Ϊ���Ը�ֵ
		Method method = pd.getWriteMethod();//setAge
		method.invoke(p, 45);
		
		//��ȡ���Ե�ֵ
		method = pd.getReadMethod();//getAge
		System.out.println(method.invoke(p,null));
	}

	//�߼�������ݣ���ȡ��ǰ���������Ե�����
	@Test
	public void test3() throws Exception{

		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		
		System.out.println(pd.getPropertyType());
		
		
	}

}
