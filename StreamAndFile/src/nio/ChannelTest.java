package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class ChannelTest {
	@Test
	public void test1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("E:/zzsglLog.txt","rw");
		FileChannel channel = raf.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(2048*20);
		while(true){
			buffer.clear();
			int len = channel.read(buffer);
			if(len==-1 || len==0){
				break;
			}
			buffer.flip();
			while(buffer.hasArray()){
				System.out.println(new String(buffer.array()));
				break;
			}
		}
		raf.close();
	}
	
}
