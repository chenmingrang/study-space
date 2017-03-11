/**
 * 
 */
package socketTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 陈明让
 * @data 2017年3月4日
 */
public class EchoServer {
	public static void main(String[] args) throws Exception{
		ServerSocket s = new ServerSocket(8899);
		Socket incoming = s.accept();
		InputStream inStream = incoming.getInputStream();
		OutputStream outStream = incoming.getOutputStream();
		Scanner in = new Scanner(inStream);
		PrintWriter out = new PrintWriter(outStream,true);
		out.println("Hello! Enter BYE to exit.");
		boolean done = false;
		while (!done&&in.hasNextLine()) {
			String line = in.nextLine();
			out.println("Echo:"+line);
			if("BYE".equalsIgnoreCase(line.trim()))
				done=true;
		}
	}
}
