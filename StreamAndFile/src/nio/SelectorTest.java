package nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

import org.junit.Test;

/**
 * Selector（选择器）是Java NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件。
 * 这样，一个单独的线程可以管理多个channel，从而管理多个网络连接。
 * 
 * 仅用单个线程来处理多个Channels的好处是，只需要更少的线程来处理通道。 事实上，可以只用一个线程处理所有的通道。
 * 对于操作系统来说，线程之间上下文切换的开销很大，而且每个线程都要占用系统的一些资源（如内存）。因此，使用的线程越少越好。
 * 
 * @date 2017-2-2
 * @author *_* 陈明让 *_*
 */
public class SelectorTest {
	@Test
	public void test1() throws Exception{
		FileOutputStream fos1 = new FileOutputStream("E:/testTransferFrom1.txt");
		FileChannel channel1 = fos1.getChannel();
		FileOutputStream fos2 = new FileOutputStream("E:/testTransferFrom2.txt");
		FileChannel channel2 = fos2.getChannel();
		Selector selector = Selector.open();
//		SelectionKey key1 = channel1.
	}
}
