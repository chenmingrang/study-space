package xmlStransfer;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class JAXBDemo {
	
	@Test
	public void testMarshall(){
		File xmlFile = new File("xmlParse/test.xml");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Article.class);
			Marshaller m = context.createMarshaller();
			Article article = new Article("cmr", "cmr@126.com", "thinking in java");
			
			m.marshal(article, xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUnMarsall()throws Exception{
		File xmlFile = new File("xmlParse/test.xml");
		JAXBContext context =JAXBContext.newInstance(Article.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Article article = (Article) unmarshaller.unmarshal(xmlFile);
		System.out.println(article);
	}
	
	@Test
	public void testUnMarsallList() throws Exception{
		File xmlFile = new File("xmlParse/articles.xml");
		JAXBContext context =JAXBContext.newInstance(ArticleData.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ArticleData data = (ArticleData) unmarshaller.unmarshal(xmlFile);
		List<Article> list = data.getArticles();
		for (Article article:list) {
			System.out.println(article);
		}
	}
}
