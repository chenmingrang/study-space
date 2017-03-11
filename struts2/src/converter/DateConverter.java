package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/*
 * 自定义转换器：
 * 	* 作用：就是把页面中createTime元素的字符串内容转换成java.util.Date
 */
public class DateConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Object value, Class toType) {
		
		//要转换的值：[Ljava.lang.String;@3da850
		System.out.println("value = "+value);
		
		//要转换的类型：class java.util.Date
		System.out.println("toType = "+toType);
		
		if(value==null){
			return false;
		}
		
		if(toType==null){
			return false;
		}
		
		if(toType!=java.util.Date.class){
			return false;
		}
		
		if(value instanceof java.lang.String[]){
			String [] str = (String[])value;
			
			if(str[0]!=null&&str[0].length()>0){
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					
					return sdf.parse(str[0]);
					
				} catch (ParseException e) {
					/*
					 *  在struts2框架里，自定义的类型转换器，
					 *  如果我们不手动抛出异常，struts2框架只捕获异常，但是并不抛出。
					 *  所以框架就会认为类型转换器转换成功，转向成功页面。
					 */
					throw new RuntimeException(e);
					
				}
			}
		}
		
		return new Date();
	}
	
}
