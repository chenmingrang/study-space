package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class CopyFile {
	@Test
	public void test1() throws IOException{
		String inFile = "E:/MyJob/orcaleStudy.dmp";
		String outFile2 = "E:\\copy.dmp";
		
		FileInputStream fis = new FileInputStream(inFile);
		FileOutputStream fos = new FileOutputStream(outFile2);
		
		//获取输入通道
		FileChannel inChannel = fis.getChannel();
		//获取输出通道
		FileChannel outChannel = fos.getChannel();
		//构建一个缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(2048);
		long start = System.currentTimeMillis();
		while(true){
			//重设缓冲区，使它可以接受读入的数据
			buffer.clear();
			//从输入通道中将数据读到缓冲区
			int r = inChannel.read(buffer);
			if(r==-1){
				break;
			}
			//让缓冲区可以将新读入的数据写入另一个通道
			buffer.flip();
			outChannel.write(buffer);
		}
		System.out.println((System.currentTimeMillis()-start)+" MilliSeconds");//121 MilliSeconds
		fis.close();
		fos.close();
	}
	
	@Test
	public void test2()throws IOException{
		String inFile = "E:/MyJob/orcaleStudy.dmp";
		String outFile2 = "E:\\copy.dmp";
		FileInputStream fis =new FileInputStream(inFile);
		FileOutputStream fos = new FileOutputStream(outFile2);
	    long start = System.currentTimeMillis();
		int len = 0;
		byte[] b = new byte[2048];
		while((len=fis.read(b))!=-1){
			fos.write(b, 0, len);
		}
		System.out.println((System.currentTimeMillis()-start)+" MilliSeconds");//116 MilliSeconds
		fis.close();
		fos.close();
	}
}
