package xmlStransfer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="articles")
public class ArticleData {
    List<Article> article = new ArrayList<Article>();

	public List<Article> getArticles() {
		return article;
	}

	public void setArticles(List<Article> article) {
		this.article = article;
	} 
	
	public static void main(String[] args) throws Exception{
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
