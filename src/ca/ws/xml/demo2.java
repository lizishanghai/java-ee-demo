package ca.ws.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;

public class demo2 {
	
	@Test
	public void test1() throws Exception{
		
		//1.��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2.�õ�dom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.����xml�ĵ�, �õ������ĵ���document
		Document document = builder.parse("src/book.xml");
	}

}
