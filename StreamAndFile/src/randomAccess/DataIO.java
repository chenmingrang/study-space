package randomAccess;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @date 2017-1-26
 * @author *_* 陈明让 *_*
 */
public class DataIO {
	/**
	 * @function 名字长度不一致时，到达输出长度一致的效果,str的长度小于size时，后面的补领0
	 * @param str 字符串
	 * @param size 固定长度
	 * @param out 输出流
	 * @throws IOException
	 */
	public static void writeFixedString(String str,int size,DataOutput out) throws IOException{
		for(int i=0;i<size;i++){
			char ch = 0;
			if(i<str.length())
				ch = str.charAt(i);
			out.writeChar(ch);
		}
	}
	
	/**
	 * @function 从固定长度的字节中读出员工的名字
	 * @param size 固定长度
	 * @param in 输入流
	 * @return 员工名字
	 * @throws IOException
	 */
	public static String readFixedString(int size,DataInput in)throws IOException{
		StringBuffer sb = new StringBuffer(size);
		int i = 0;
		boolean more = true;
		while(more && i<size){
			char ch = in.readChar();
			i++;
			if(ch==0)
				more =false;
			else
				sb.append(ch);
		}
		//跳过剩余的0，开始读工资信息
		in.skipBytes(2*(size-i));
		return sb.toString();
	}
}
