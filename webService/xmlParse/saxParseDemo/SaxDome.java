package saxParseDemo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDome {
	public static void main(String[] args) throws Exception {
		File xmlFile = new File("XMLTest/saxParseDemo/article.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		MyHandler myHandler = new MyHandler();
		parser.parse(xmlFile, myHandler);
		System.out.println("总共"+myHandler.getResult().size()+"个元素:"+myHandler.getResult());
	}
}

class MyHandler extends DefaultHandler {
	private List<Map<String, String>> result = new ArrayList<Map<String, String>>();
	private Map<String, String> map = new HashMap<String, String>();
	private String content;

	public List<Map<String, String>> getResult() {
		return result;
	}

	public void setResult(List<Map<String, String>> result) {
		this.result = result;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("title") || qName.equals("author")|| qName.equals("email")) {
			System.out.println("qName=" + qName);
			map.put(qName, content);
		}
		if("arcticle".equals(qName)){
			result.add(map);
			map=new HashMap<String, String>();
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals("arcticle")) {
			System.out.println();
			map.put("category", attributes.getValue("category"));
		}
	}
}
