类型转换：
	
	* 从页面中获取对应的内容
		
		* 在动作类action中，声明与页面中表单name属性的值同名的属性
		* 提供get和set方法
		* struts2框架就会通过反射机制，从页面中获取对应的内容
		
	* struts2框架不能把页面中获取到的字符串类型转换成任何类型
	
	* 当struts2框架不能把页面中获取到的字符串类型进行转换时，就需要自定义类型转换器
	
	* 自定义类型转换器：
		
		* 要么实现TypeConverter接口或者继承TypeConverter接口的某个实现类，我们继承DefaultTypeConverter类
		
		* 重写convertValue(Object value, Class toType){}方法
		
			* 参数"value"：要转换的值
			* 参数"toType"：要转换的类型
			
		* 具体代码实现：
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
		
		* 两种注册方式：
			* 基于字段的(局部)
				
				* 在动作类action同目录下，创建一个名为"UserAction-conversion.properties"的资源文件
					* UserAction为动作类action的名称
					* "-conversion.properties"是固定写法
				
				* 其内容配置如下：
					createTime=cn.itcast.converter.DateConverter
				
			* 基于类的(全局)
				
				* 在src目录下，创建一个名为"xwork-conversion.properties"的资源文件
					* 该资源文件的名称是固定的
				
				* 其内容配置如下：
					java.util.Date=cn.itcast.converter.DateConverter
		
		* 如果在页面中输入一个不正确的值的时候，不手动抛出异常，页面依然转向成功页面
			/*
			 *  在struts2框架里，自定义的类型转换器，
			 *  如果我们不手动抛出异常，struts2框架只捕获异常，但是并不抛出。
			 *  所以框架就会认为类型转换器转换成功，转向成功页面。
			 */
		
		* 配置修改错误提示信息为中文
			
			* 在动作类action同目录下，创建一个名为"converter.properties"的资源文件
			
			* 该资源文件配置如下：
				
				* 针对所有字段：
					xwork.default.invalid.fieldvalue=类型转换失败 "{0}".
				
				* 针对某个字段：
					invalid.fieldvalue.createTime=出生日期转换失败
			
			* 在struts.xml文件进行配置：
				<constant name="struts.custom.i18n.resources" 
						value="cn.itcast.converter.converter">
				</constant>
		
		
		