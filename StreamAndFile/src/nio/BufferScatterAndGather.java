package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;
/**
 * scatter/gather经常用于需要将传输的数据分开处理的场合，例如传输一个由消息头和消息体组成的消息，
 * 你可能会将消息体和消息头分散到不同的buffer中，这样你可以方便的处理消息头和消息体。
 * @date 2017-2-1
 * @author *_* 陈明让 *_*
 */
public class BufferScatterAndGather {
	/*
	 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel。
	 * 因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
	 * 
	 * 注意：
	 *     buffers数组是write()方法的入参，write()方法会按照buffer在数组中的顺序，将数据写入到channel，
	 *     注意只有position和limit之间的数据才会被写入。
	 *     因此，如果一个buffer的容量为128byte，但是仅仅包含58byte的数据，
	 *     那么这58byte的数据将被写入到channel中。因此与Scattering Reads相反，Gathering Writes能较好的处理动态消息。
	 */
	@Test
	public void gatherTest() throws IOException {
		ByteBuffer head = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(512);
		String headStr = "我";
        byte[] bHead = headStr.getBytes();		
        for (int i = 0; i < head.capacity()/bHead.length; i++) {
			head.put(bHead);
		}
        for(int i = head.position();i<head.capacity();i++){
        	//换行
        	head.put((byte)13);
        }
        String bodyStr = "他";
        byte[] bBody = bodyStr.getBytes();
//        System.out.println(bBody.length+";"+body.capacity()+";"+body.position());
        for (int i = 0; i < body.capacity()/bBody.length; i++) {
        	body.put(bBody);
		}
//        System.out.println(body.position());
        FileOutputStream fos = new FileOutputStream("E:/testGather.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer[] buffers = new ByteBuffer[2];
        head.flip();
        body.flip();
        buffers[1] = body;
        buffers[0] = head;
        channel.write(buffers);
        fos.close();
	}
	
	/*
	 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
	 * 因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
	 * 注意：
	 *      buffer首先被插入到数组，然后再将数组作为channel.read() 的输入参数。
	 *      read()方法按照buffer在数组中的顺序将从channel中读取的数据写入到buffer，当一个buffer被写满后，
	 *      channel紧接着向另一个buffer中写。Scattering Reads在移动下一个buffer前，必须填满当前的buffer，这也意味着它不适用于动态消息(译者注：消息大小不固定)。
	 *      换句话说，如果存在消息头和消息体，消息头必须完成填充（例如 128byte），Scattering Reads才能正常工作
	 */
	@Test
	public void scatterTest()throws IOException{
		FileInputStream fis = new FileInputStream("E:/testGather.txt");
		FileOutputStream fos = new FileOutputStream("E:/testCopy.txt");
		FileChannel outChannel = fos.getChannel();
		FileChannel channel = fis.getChannel();
		ByteBuffer b0 = ByteBuffer.allocate(128);
		ByteBuffer b1 = ByteBuffer.allocate(512);
		ByteBuffer[] buffers = new ByteBuffer[2];
		buffers[0] = b0;
		buffers[1] = b1;
		channel.read(buffers);
		System.out.print(new String(b0.array(),0,b0.position()));
		System.out.println(new String(b1.array(),0,b1.position()));
		b0.flip();
		b1.flip();
		outChannel.write(buffers);
		fos.close();
	}
}
