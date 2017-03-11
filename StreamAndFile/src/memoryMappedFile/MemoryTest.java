package memoryMappedFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class MemoryTest {
	public static long checksumInputStream(String file) throws IOException {
		InputStream in = new FileInputStream(file);
		CRC32 crc = new CRC32();
		int c;
		while ((c = in.read()) != -1) {
			crc.update(c);
		}
		return crc.getValue();
	}

	public static long checksumBufferedInputStream(String file)throws IOException{
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		CRC32 crc = new CRC32();
		int c;
		while ((c = in.read()) != -1) {
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumRandomAccessFile(String file)throws IOException{
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		long length = raf.length();
		CRC32 crc = new CRC32();
		for(long p=0;p<length;p++){
			raf.seek(p);
			int c =raf.readByte();
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumMappedFile(String file)throws IOException{
		FileInputStream fis = new FileInputStream(file);
		FileChannel channel = fis.getChannel();
		CRC32 crc = new CRC32();
		int length = (int) channel.size();
		//将文件的一个区域映射到内存中
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
		for(int i = 0;i<length;i++){
			int c = buffer.get(i);
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static void main(String[] args)throws IOException{
		String file = "E:/MyJob/orcaleStudy.dmp";
		
		System.out.println("Input Stream:");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStream(file);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));//de173b67
		System.out.println((end-start)+" MilliSeconds");//43673 MilliSeconds
		
		System.out.println("Buffered Input Stream:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(file);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));//de173b67
		System.out.println((end-start)+" MilliSeconds");//468 MilliSeconds
		
		System.out.println("Random Access File:");
		start = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(file);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));//de173b67
		System.out.println((end-start)+" MilliSeconds");//56126 MilliSeconds
		
		System.out.println("Mapped File:");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(file);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));//de173b67
		System.out.println((end-start)+" MilliSeconds");//406 MilliSeconds
	}
}
