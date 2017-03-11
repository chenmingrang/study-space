/**
 * 
 */
package nio.test;

import java.net.InetSocketAddress;
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
public class Client {
    /**
	 * @return the selector
	 */
	public Selector getSelector() {
		return selector;
	}

	/**
	 * @param selector the selector to set
	 */
	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	private Selector selector;
    
    public void initClient(String ip,int port)throws Exception{
    	SocketChannel channel = SocketChannel.open();
    	channel.configureBlocking(false);
    	selector = Selector.open();
    	channel.connect(new InetSocketAddress(ip, port));
    	//将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
    	channel.register(selector, SelectionKey.OP_CONNECT);
    }
    
    public void listen()throws Exception{
    	while(true){
    		selector.select();
    		Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
    		while(iterator.hasNext()){
    			SelectionKey key = iterator.next();
    			iterator.remove();
    			if(key.isConnectable()){
    				SocketChannel channel = (SocketChannel) key.channel();
    				 // 如果正在连接，则完成连接  
    				if(channel.isConnectionPending()){
    					channel.finishConnect();
    				}
    				channel.configureBlocking(false);
    				channel.register(selector, SelectionKey.OP_READ);
    				Scanner scan = new Scanner(System.in);
    				while(true){
    					System.out.println("向服务器发信息：");
    					String string = scan.next();
    					channel.write(ByteBuffer.wrap(string.getBytes()));
    					//在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。 
    				}
    			}else if(key.isReadable()){
    				readInfo(key);
    			}
    		}
    	}
    }
    
	/**
	 * @date 2017年2月11日
	*  @return readInfo
	 */
	private void readInfo(SelectionKey key) throws Exception{
		// 服务器可读取消息:得到事件发生的Socket通道  
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		System.out.println("服务端："+new String(buffer.array()));
//		ByteBuffer outBuffer = ByteBuffer.wrap("来自客户端的问候！".getBytes());
//		channel.write(outBuffer);
	}
	
	public static void main(String[] args) throws Exception{
		Client client = new Client();
		client.initClient("localhost", 8999);
		new Handler(true, client.getSelector()).start();;//写线程
		new Handler(false, client.getSelector()).start();;//读线程
	}
}
