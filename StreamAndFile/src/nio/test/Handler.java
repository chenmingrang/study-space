/**
 * 
 */
package nio.test;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 陈明让
 * @data 2017年2月11日
 */
public class Handler extends Thread {
	private Boolean writer;
	private Selector selector;

	public Handler(boolean writer, Selector selector) {
		this.writer = writer;
		this.selector = selector;
	}

	@Override
	public void run() {
		try {
			while (true) {
				selector.select();
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();
					if (key.isConnectable() && writer) {
						SocketChannel channel = (SocketChannel) key.channel();
						// 如果正在连接，则完成连接
						if (channel.isConnectionPending()) {
							channel.finishConnect();
						}
						channel.configureBlocking(false);
						channel.register(selector, SelectionKey.OP_READ);
						Scanner scan = new Scanner(System.in);
						while (true) {
							System.out.println("向服务器发信息：");
							String string = scan.nextLine();
							channel.write(ByteBuffer.wrap(string.getBytes()));
							// 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
						}
					}else if(key.isReadable()){
						readInfo(key);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readInfo(SelectionKey key) throws Exception {
		// 服务器可读取消息:得到事件发生的Socket通道
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		System.out.println("服务端：" + new String(buffer.array()));
		// ByteBuffer outBuffer = ByteBuffer.wrap("来自客户端的问候！".getBytes());
		// channel.write(outBuffer);
	}
}
