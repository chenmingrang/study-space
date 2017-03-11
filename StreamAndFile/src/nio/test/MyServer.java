/**
 * 
 */
package nio.test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author 陈明让
 * @data 2017年2月11日
 */
public class MyServer {
	// 通道管理器
	private Selector selector;

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public void initServer(int port)throws Exception{
		 // 获得一个ServerSocket通道 
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		//非阻塞
		serverChannel.configureBlocking(false);
		 // 将该通道对应的ServerSocket绑定到port端口  
		serverChannel.socket().bind(new InetSocketAddress(port));
		//获得通道处理器
		this.selector = Selector.open();
		 //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，  
        //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。  
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	@SuppressWarnings("rawtypes")
	public void listen()throws Exception{
		System.out.println("服务器启动成功！");
		while(true){
			//当注册的事件到达时，方法返回；否则,该方法会一直阻塞  
			selector.select();
			//获得selector中选中的项的迭代器，选中的项为注册的事件  
			Iterator iterator = selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey key = (SelectionKey) iterator.next();
				//删除已选的key,以防重复处理  
				iterator.remove();
				// 客户端请求连接事件  
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					// 获得和客户端连接的通道  
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					//给客户端发送信息
					channel.write(ByteBuffer.wrap("你好，客户端!".getBytes()));
					//在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
					channel.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					readInfo(key);
				}
			}
		}
	}
	
	public void readInfo(SelectionKey key)throws Exception{
		// 服务器可读取消息:得到事件发生的Socket通道  
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		System.out.println("客户端："+new String(buffer.array()));
		ByteBuffer outBuffer = ByteBuffer.wrap("来自服务端的问候！".getBytes());
		channel.write(outBuffer);
	}
	
	public static void main(String[] args) throws Exception{
		MyServer server = new MyServer();
		server.initServer(8999);
		server.listen();
	}
}
