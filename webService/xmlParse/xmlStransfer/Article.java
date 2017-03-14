package xmlStransfer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {
	private String author;
	private String Email;
	private String title;

	public Article() {
	}

	@Override
	public String toString() {
		return "Article [author=" + author + ", Email=" + Email + ", title="
				+ title + "]";
	}

	public Article(String author, String email, String title) {
		super();
		this.author = author;
		Email = email;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
