package zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

public class ZipTest {
	@Test
	public void test1() throws IOException {
		FileOutputStream fos = new FileOutputStream("E:\\test.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry entry;
		entry = new ZipEntry("emp.txt");
		long l1 = 20L*365*24*60*60*1000;
		entry.setTime(l1);
		entry.setComment("测试一下");
		//将entry设置进去
		zos.putNextEntry(entry);
		FileInputStream fis = new FileInputStream("E:\\fwskLog.txt");
		byte[] b = new byte[1024];
		int len =0;
		while((len = fis.read(b)) != -1){
			if(len<1024){
				byte[] newB = Arrays.copyOfRange(b, 0, len);
				zos.write(newB);
			}else {
				zos.write(b);
			}
		}
		zos.closeEntry();
		zos.close();
	}
	
	@Test
	public void test2() throws IOException {
		ZipInputStream zin = new ZipInputStream(new FileInputStream("E:\\test.zip"));
		ZipEntry entry;
		while((entry = zin.getNextEntry()) !=null){
			System.out.println(entry.getName()+";"+new Date(entry.getTime())+";"+entry.getComment());
			zin.closeEntry();
		}
		zin.close();
	}
}
