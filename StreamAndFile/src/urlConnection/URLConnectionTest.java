package urlConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author 陈明让
 * @data 2017年3月5日
 */
public class URLConnectionTest {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://docs.oracle.com/apps/search/search.jsp");
		URLConnection connection = url.openConnection();
		connection.connect();
		Map<String, List<String>> headers = connection.getHeaderFields();
		for(Map.Entry<String, List<String>> entry:headers.entrySet()){
			String key = entry.getKey();
			for (String value : entry.getValue()) {
				System.out.println(key+"==>"+value);
			}
		}
		
		System.out.println("-------------------");
		System.out.println("getContentType:"+connection.getContentType());
		System.out.println("getContentLength:"+connection.getContentLength());
		System.out.println("getContentEncoding:"+connection.getContentEncoding());
		System.out.println("getDate:"+connection.getDate());
		System.out.println("getExpiration:"+connection.getExpiration());
		System.out.println("getLastModified:"+connection.getLastModified());
		System.out.println("-------------------");
	}
}
