package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * Java NIO中的Buffer用于和NIO通道进行交互。如你所知，数据是从通道读入缓冲区，从缓冲区写入到通道中的。
 * 缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。
 * 这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
 * 使用buffer的步骤：
 *    1.写入数据到Buffer 
 *    2.调用flip()方法 
 *    3.从Buffer中读取数据
 *    4.调用clear()方法或者compact()方法
 * @date 2017-1-31
 * @author *_* 陈明让 *_*
 */
public class BufferTest {
	/*
	 * 为了理解Buffer的工作原理，需要熟悉它的三个属性：
	 *    1.capacity:
	 *        作为一个内存块，Buffer有一个固定的大小值，也叫“capacity”.
	 *        你只能往里写capacity个byte、long，char等类型。一旦Buffer满了，
	 *        需要将其清空（通过读数据或者清除数据）才能继续写数据往里写数据。
	 *    2.position:
	 *        2.1.当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.
	 *            当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。
	 *            position最大可为capacity – 1.
              2.2.当读取数据时，也是从某个特定位置读。当将Buffer从写模式切换到读模式，position会被重置为0.
                                    当从Buffer的position处读取数据时，position向前移动到下一个可读的位置。
	 *    3.limit
	 *        3.1.在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。
	 *        3.2.当切换Buffer到读模式时， limit表示你最多能读到多少数据。
	 *            因此，当切换Buffer到读模式时，limit会被设置成写模式下的position值。
	 *            换句话说，你能读到之前写入的所有数据（limit被设置成已写数据的数量，这个值在写模式下就是position）
	 */
	@Test
	public void test1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("E:/zzsglLog.txt", "rw");
		FileOutputStream fos = new FileOutputStream("E:/copy.txt");
		FileChannel channel = raf.getChannel();
		FileChannel outChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			//清空缓冲区，以便读入数据
			/*
			 * 如果调用的是clear()方法，position将被设回0，limit被设置成 capacity的值。
			 * 换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。
             * 如果Buffer中有一些未读的数据，调用clear()方法，数据将“被遗忘”，意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
             */
			/***************************************************************************************************/
			/*
			 * compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。
			 * limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
			 */
			buffer.clear();
			/*************************写数据到Buffer有两种方式：******************************/
			// 1.从Channel写到Buffer的例子
			// 2.通过put方法写Buffer的例子：
			int len = channel.read(buffer);
			if (len == -1 || len == 0) {
				break;
			}
			/*************************切换到“读”模式，以便从缓冲区中读数据***********************/
			//flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
            //换句话说，position现在用于标记读的位置，limit表示之前写进了多少个byte、char等 —— 现在能读取多少个byte、char等。
			buffer.flip();
			//buffer.limit()最多能读多少数据
			System.out.println(new String(buffer.array(),0,buffer.limit()));
			/*************************从Buffer中读取数据有两种方式：**************************/
		    // 1.从Buffer读取数据到Channel。
			// 2.使用get()方法从Buffer中读取数据。
			outChannel.write(buffer);
		}
		raf.close();
	}
}
