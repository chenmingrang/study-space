struts2框架的文件上传：
	* 单文件上传：
		* 在动作类action中声明相关属性：
			* 在动作类action中，要声明与页面中表单name属性同名的属性，同名的属性的类型时File类型；
			* 在动作类action中，要声明[同名的属性]ContentType，类型时String类型；
			* 在动作类action中，要声明[同名的属性]FileName，类型时String类型
			* 给所有属性提供get和set方法
		* 在业务方法中，处理文件上传：
			* 获取要上传文件的路径，保存的位置
			* 在目标文件夹内，创建一个与上传文件同名的文件
			* 通过FileUtils工具类提供copyFile()方法，将临时文件内容拷贝到目标文件夹下的那个同名的文件
		* 设置上传文件的总大小
			* 在struts.xml文件中，<constant name="struts.multipart.maxSize" value="2097152000"></constant>
		* 设置上传文件的大小、类型和扩展名：
			* 在自定义的配置文件中，在action标签下：
				<!-- 配置拦截器的参数，这里是文件上传拦截器 -->
				<interceptor-ref name="defaultStack">
	              	<!-- 
	              		配置文件上传拦截器的参数
	              			* 与定义参数的顺序无关
	              			* 允许的类型(allowedTypes)和允许的扩展名(allowedExtensions)必须保持一致
	              	 -->
	              	<!-- 
	              		* 配置上传文件的大小
	              			* struts.xml文件中配置的是上传文件的总大小
	              			* 这里配置的是上传文件的单个大小
	              	 -->
	              	<param name="fileUpload.maximumSize">20971520</param>
	              	<!-- 配置上传文件允许的类型，如果配置多个值的话，用","隔开 -->
	              	<param name="fileUpload.allowedTypes">text/plain,application/msword</param>
	              	<!-- 配置上传文件的扩展名，如果配置多个值的话，用","隔开 -->
	              	<param name="fileUpload.allowedExtensions">.txt</param>
	            </interceptor-ref>
	         * 自定义上传文件的错误提示信息：
	         	* 在动作类action同目录下，创建一个名为fileuploadmessage.properties资源文件(名为自定义)
	         	* 改资源文件配置如下：
	         		struts.messages.error.uploading=Error uploading: {0}
					struts.messages.error.file.too.large=File too large: {0} "{1}" "{2}" {3}
					struts.messages.error.content.type.not.allowed=Content-Type not allowed: {0} "{1}" "{2}" {3}
					struts.messages.error.file.extension.not.allowed=File extension not allowed: {0} "{1}" "{2}" {3}
		
		
	* 多文件上传：
		* 所有流程于配置都与单文件上传一致。
		* 需要注意的是：
			* 在页面中，虽然是多文件上传，但是页面中表单的name属性的值必须保持一致；
			* 在动作类action中声明的相关属性，类型改成数组；
			* 在业务方法中，相关处理流程改成单文件上传的循环。
		
		