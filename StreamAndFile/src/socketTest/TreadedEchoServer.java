package socketTest;

import java.io.IOException;
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
public class TreadedEchoServer {
	public static void main(String[] args) {
		try {
			int i = 1;
			ServerSocket server = new ServerSocket(8899);
			while(true){
				Socket incoming = server.accept();
				System.out.println("Swaping "+i);
				Runnable r = new Threadedhandler(incoming);
				new Thread(r).start();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


class Threadedhandler implements Runnable{
	private Socket incoming;
	
	public Threadedhandler(Socket s) {
		this.incoming = s;
	}
	
	@Override
	public void run() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				incoming.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}