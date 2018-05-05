package ca.ws.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//使用dom方式对xml进行crud
public class demo3 {
	
	//读取xml文档中： <title lang="en">Harry Potter</title> 节点中的值
	@Test
	public void read1() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		NodeList list = document.getElementsByTagName("title");
		Node node = list.item(1);
		
		String content = node.getTextContent();
		System.out.println(content);
	}
	
	
	//读取xml文档中：所有标签的值
	@Test
	public void read2() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到根节点
		Node root = document.getElementsByTagName("bookstore").item(0);
		
		list(root);
	}

		
	private void list(Node node) {
		
		if(node instanceof Element){
			System.out.println(node.getNodeName());
		}
		//System.out.println(node.getNodeName());
		NodeList list = node.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node child = list.item(i);
			//System.out.println(list.item(i).getNodeName());
			list(child);
		}
	}
		

	//读取xml文档中：标签属性的值 <title lang="en">Harry Potter</title>
	@Test
	public void read3() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到根节点
		Element title = (Element) document.getElementsByTagName("title").item(1);
		String value = title.getAttribute("lang");
		System.out.println(value);
	}
	
	
	//向xml文档中增加节点：<price>40.00</price>
	@Test
	public void add1() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//创建节点
		Element price = document.createElement("price");
		price.setTextContent("40.00");
		
		//把创建的节点挂到第一本书上
		Element book = (Element) document.getElementsByTagName("book").item(0);
		book.appendChild(price);
		
		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	
	//向xml文档中指定位置增加节点：<price>40.00</price>
	@Test
	public void add2() throws Exception{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//创建节点
		Element price = document.createElement("price");
		price.setTextContent("40.00");
		
		//得到参考节点
		Element refNode = (Element) document.getElementsByTagName("price").item(0);

		//得到要加载的节点
		Element book = (Element) document.getElementsByTagName("book").item(0);

		//往加载节点的指定位置添加
		book.insertBefore(price, refNode);
		
		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
		
	
	//向xml文档节点上添加属性：<title lang="en">Harry Potter</title>上添加name="xxx"属性
	@Test
	public void addAttr() throws Exception{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element title = (Element) document.getElementsByTagName("title").item(1);
		title.setAttribute("name", "xxx");
		
		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));

	}
		
	
	//从xml文档上删除节点
	@Test
	public void delete1() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到要删除的节点;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		
		//得到要删出节点的爸爸
		Element book = (Element) document.getElementsByTagName("book").item(0);
		
		//爸爸再删除子节点
		book.removeChild(e);

		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));

	}
	

	//从xml文档上删除节点
	@Test
	public void delete2() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到要删除的节点;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		e.getParentNode().removeChild(e);
		
		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	//从xml文档上更新节点
	@Test
	public void update() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//得到要更新的节点;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		e.setTextContent("109");
		
		//把更新后的内存写回文档
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

}
