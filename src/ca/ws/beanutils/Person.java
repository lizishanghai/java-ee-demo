package ca.ws.beanutils;

import java.util.Date;

public class Person {	// javabean

	private String name;	//×Ö¶Î
	private String password;	//×Ö¶Î
	private int age;	//×Ö¶Î
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAb(){	
		return null;
	}
	
	public String getName() {	//ÊôÐÔ
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
