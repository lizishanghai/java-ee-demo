package ca.ws.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;

public class demo2 {
	
	@Test
	public void test1() throws Exception{
		
		//1.创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//2.得到dom解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.解析xml文档, 得到代表文档的document
		Document document = builder.parse("src/book.xml");
	}

}
