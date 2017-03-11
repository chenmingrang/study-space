package regex;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HrefMatch {
	public static void main(String[] args) throws Exception {
		String urlString = "http://docs.oracle.com/cd/B28359_01/appdev.111/b28370/subprograms.htm#LNPLS008";
		InputStreamReader reader = new InputStreamReader(new URL(urlString).openStream());
		StringBuffer input = new StringBuffer();
		int ch;
		while((ch=reader.read())!=-1){
			input.append((char)ch);
		}
		System.out.println(input.toString());
		String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
		Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			int start = matcher.start();
			int end = matcher.end();
			String match = input.substring(start,end);
			System.out.println(match);
		}
	}
	
	@Test
	public void test1(){
		Pattern pattern =Pattern.compile("\\s+");
		String[] token = pattern.split("  222 23 /!");
		for (int i = 0; i < token.length; i++) {
			System.out.println(token[i]);
		}
	}
}
