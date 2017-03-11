package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		/*
		 * Enter pattern: 
         *    ((1?[0-9]):([0-5][0-9]))[ap]m
         *  Enter string to match
         *    11:59am
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pattern: ");
		String patternString = in.nextLine();
		Pattern pattern = Pattern.compile(patternString);
		while(true){
			System.out.println("Enter string to match:");
			String input = in.nextLine();
			System.out.println(input);
			if(input==null || "".equals(input)) return;
			Matcher matcher = pattern.matcher(input);
			if(matcher.matches()){
				System.out.println("Match");
				int g = matcher.groupCount();
				if(g > 0 ){
					for(int i = 0;i < input.length();i++){
						//print any empty groups
						for(int j = 1;j <= g;j++){
							if(i==matcher.start(j) && i == matcher.end(j)){
								System.out.print("()");
							}
						}
						//print ( for non-empty groups starting here
						for(int j = 1;j<=g;j++){
							if(i ==matcher.start(j) && i !=matcher.end(j)){
								System.out.print("(");
							}
						}
						System.out.print(input.charAt(i));
						//print ) for non-empty group ending here
						for(int j = 1;j<=g;j++){
							if(i+1 != matcher.start(j) && i+1 == matcher.end(j)){
								System.out.print(")");
							}
						}
					}
					System.out.println();
				}
			}else {
				System.out.println("No Match");
			}
		}
	}
}
