package dom4jTest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestCase {
	@Test
	public void test1() throws Exception{
		SAXReader reader = new SAXReader(false);
		Document doc = reader.read("xmlParse/articles.xml");
		List<Element> list = doc.selectNodes("/articles/article");
		System.out.println(list.size());
	}
}
