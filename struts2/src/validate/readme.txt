struts2手动验证：
	* 首先要从页面中获取对应的标签name属性的值，在动作类action中声明同名的属性，提供get和set方法
	
	* 要继承ActionSupport类或者实现Validateable接口
	
	* 重写Validateable接口的validate()方法
		* 前提是：要保证setUsername()、validate()、login()方法要按照这个先后顺序执行
	
	* 如果登录失败，如何处理：
		* this.addFieldError( key, value);
			* key：错误提示字段
			* value：错误提示信息
	
	* 什么时候才是验证通过？
		* 验证通过：1、map集合不存在；2、map集合存在并为空
		* 验证不通过：map集合存在并且不为空
	
	* 分析需求：
		* 用户名不能为null ,""
		* 密码不能为null, "" ，并且密码的长度6-12之间 
	
	* 针对所有业务方法进行验证还是针对某个指定业务方法进行验证？
		* 重写的validate()方法，针对所有业务方法进行验证
		* 重写的validate()方法加上要验证的指定的业务方法名(业务方法名的首字母大写)，实现针对某个指定的业务方法进行验证
			* 为什么要这样进行拼接？因为struts2框架底层拼接，如果不这样写，底层就找不到对应方法名
	
struts2框架验证(xml方式):
	* 首先要从页面中获取对应的标签name属性的值，在动作类action中声明同名的属性，提供get和set方法
	
	* 创建一个xml格式验证文件：
		* 命名方式：ActionClassName-validation.xml，ActionClassName指的是动作类action的名称
		* <validators>标签：根元素
		* field：指定action中要校验的属性，实际上就是页面中表单的name属性的值
			* name：指定页面中表单的name属性的值
		* field-validator：指定验证规则
			* type：指定验证规则名称，
					struts2框架提供的验证规则放在xwork-core-xxx.jar
					下的com\opensymphony\xwork2\validator\validators
					的default.xml配置文件。
		* param：向底层的验证规则传递的参数
		* message：验证失败时，提供的错误提示信息
	
	* 如果要对指定方法进行验证的话：
		* xml验证文件的命名方式：ActionClassName-ActionName-validation.xml，
								ActionName对应的是struts.xml文件对应的action标签的name属性的值
	
	
	