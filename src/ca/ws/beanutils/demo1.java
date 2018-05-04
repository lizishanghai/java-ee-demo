package ca.ws.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

//ʹ��beanUtils����bean�����ԣ�������jar����
public class demo1 {
	
	@Test
	public void test1() throws Exception{
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "xxa");
		
		System.out.println(p.getName());
	}

	//����Ĵ�����������ģ���ΪbeanUtilsֻ֧�ֻ�����������ת��
	@Test
	public void test2() throws Exception{
		
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age); //ֻ֧��8�ֻ�������
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
	}

	@Test
	public void test3() throws Exception{
		
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";
		
		//Ϊ�������ڸ���bean��birthday�����ϣ����Ǹ�beanUtilsע������ת����
		ConvertUtils.register(new Converter(){

			@Override
			public Object convert(Class type, Object value) {
				
				if(value==null){
					return null;
				}
				if(!(value instanceof String)){
					throw new ConversionException("ֻ֧��String���͵�ת��");
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;				
				}
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);// �쳣�����ܵ�
				}
			}
			
		}, Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age); //ֻ֧��8�ֻ�������
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
		

	}
	

	@Test
	public void test4() throws Exception{
		
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birthday = "1980-09-09";
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age); //ֻ֧��8�ֻ�������
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
	}
	
	//��map�е�ֵ���bean������
	@Test
	public void test5() throws Exception, InvocationTargetException{
		
		Map map = new HashMap();
		map.put("name", "aaa");
		map.put("password", "12345");
		map.put("age", "34");
		map.put("birthday", "1980-09-09");
		
		Person p = new Person();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(p, map);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
	}
	
}
