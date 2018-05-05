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

//ʹ��dom��ʽ��xml����crud
public class demo3 {
	
	//��ȡxml�ĵ��У� <title lang="en">Harry Potter</title> �ڵ��е�ֵ
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
	
	
	//��ȡxml�ĵ��У����б�ǩ��ֵ
	@Test
	public void read2() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�õ����ڵ�
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
		

	//��ȡxml�ĵ��У���ǩ���Ե�ֵ <title lang="en">Harry Potter</title>
	@Test
	public void read3() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�õ����ڵ�
		Element title = (Element) document.getElementsByTagName("title").item(1);
		String value = title.getAttribute("lang");
		System.out.println(value);
	}
	
	
	//��xml�ĵ������ӽڵ㣺<price>40.00</price>
	@Test
	public void add1() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�����ڵ�
		Element price = document.createElement("price");
		price.setTextContent("40.00");
		
		//�Ѵ����Ľڵ�ҵ���һ������
		Element book = (Element) document.getElementsByTagName("book").item(0);
		book.appendChild(price);
		
		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	
	//��xml�ĵ���ָ��λ�����ӽڵ㣺<price>40.00</price>
	@Test
	public void add2() throws Exception{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�����ڵ�
		Element price = document.createElement("price");
		price.setTextContent("40.00");
		
		//�õ��ο��ڵ�
		Element refNode = (Element) document.getElementsByTagName("price").item(0);

		//�õ�Ҫ���صĽڵ�
		Element book = (Element) document.getElementsByTagName("book").item(0);

		//�����ؽڵ��ָ��λ�����
		book.insertBefore(price, refNode);
		
		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
		
	
	//��xml�ĵ��ڵ���������ԣ�<title lang="en">Harry Potter</title>�����name="xxx"����
	@Test
	public void addAttr() throws Exception{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element title = (Element) document.getElementsByTagName("title").item(1);
		title.setAttribute("name", "xxx");
		
		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));

	}
		
	
	//��xml�ĵ���ɾ���ڵ�
	@Test
	public void delete1() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�õ�Ҫɾ���Ľڵ�;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		
		//�õ�Ҫɾ���ڵ�İְ�
		Element book = (Element) document.getElementsByTagName("book").item(0);
		
		//�ְ���ɾ���ӽڵ�
		book.removeChild(e);

		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));

	}
	

	//��xml�ĵ���ɾ���ڵ�
	@Test
	public void delete2() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�õ�Ҫɾ���Ľڵ�;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		e.getParentNode().removeChild(e);
		
		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	//��xml�ĵ��ϸ��½ڵ�
	@Test
	public void update() throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		
		//�õ�Ҫ���µĽڵ�;
		Element e = (Element) document.getElementsByTagName("price").item(0);
		e.setTextContent("109");
		
		//�Ѹ��º���ڴ�д���ĵ�
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

}
