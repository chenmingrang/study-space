package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import org.junit.Test;
/**
 * 在Java NIO中，如果两个通道中有一个是FileChannel，
 * 那你可以直接将数据从一个channel（译者注：channel中文常译作通道）传输到另外一个channel。
 * @date 2017-2-2
 * @author *_* 陈明让 *_*
 */
public class ChannelTransfer {

	@Test
	public void transferFrom()throws Exception{
		FileInputStream fis = new FileInputStream("E:/testGather.txt");
		FileChannel fromChannel = fis.getChannel();
		
		FileOutputStream fos = new FileOutputStream("E:/testTransferFrom1.txt");
		FileChannel toChannel = fos.getChannel();
		
		fromChannel.position(128);
		long count = toChannel.transferFrom(fromChannel, 0, 512);
//		long count = toChannel.transferFrom(fromChannel, 0, 128);
		System.out.println(count);
		
		fis.close();
		fos.close();
	}
	
	@Test
	public void transferTo()throws Exception{
		FileInputStream fis = new FileInputStream("E:/testGather.txt");
		FileChannel fromChannel = fis.getChannel();
		
		FileOutputStream fos = new FileOutputStream("E:/testTransferFrom2.txt");
		FileChannel toChannel = fos.getChannel();
		
		long count = fromChannel.transferTo(128, 512, toChannel);
		System.out.println(count);
		
		fis.close();
		fos.close();
	}
}
