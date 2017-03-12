/**
 * 
 */
package classLoader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 陈明让
 * @data 2017年3月12日
 */
public class Caeser {
	public static void main(String[] args) {
		if(args.length!=3){
			System.out.println("USAGE:java classLoader.Caeser in out key");
			return;
		}
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			int key = Integer.parseInt(args[2]);
			int ch;
			while ((ch=fis.read())!=-1) {
				byte c=(byte)(ch+key);
				fos.write(c);
			}
		} catch (Exception e) {
		}
	}
}
