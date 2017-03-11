如何自定义拦截器：
	* 所有的拦截器都需要实现Interceptor接口或者继承Interceptor接口的扩展实现类
	
	* 要重写init()、intercept()、destroy()方法
	
		* init()是在struts2框架运行时执行，在拦截器的生命周期中只执行一次，可以做必要的内容的初始化工作
		
		* intercept()，是每一次请求就执行一次，做相关处理工作。
		
			* intercept()方法接收一个ActionInvocation接口的实例
			
			* 通过这个接口的实例，可以获取以下内容
			：
				//cn.itcast.aop.UserAction@15b5783，动作类的对象
				System.out.println("invocation.getAction() : "+invocation.getAction());
				
				//cn.itcast.aop.UserAction@15b5783，与invocation.getAction()方法获取的是同一的对象
				System.out.println("invocation.getProxy().getAction() : "+invocation.getProxy().getAction());
				
				//userAction_save，自定义配置文件中的action标签的name属性的值
				System.out.println("invocation.getProxy().getActionName() : "+invocation.getProxy().getActionName());
				
				//save，对应动作类指定要执行的方法名
				System.out.println("invocation.getProxy().getMethod() : "+invocation.getProxy().getMethod());
				
				//	/aop，自定义配置文件中的package标签的namespace属性的值
				System.out.println("invocation.getProxy().getNamespace() : "+invocation.getProxy().getNamespace());
				
		* destroy()是在拦截器销毁前执行，在拦截器的声明周期中只执行一次。
		
	* 在struts.xml配置文件中，进行注册
		* 在配置文件中的package标签下，进行相关配置：
		
		<interceptors>
			<!-- 声明自定义的拦截器 -->
			<interceptor name="expessionInterceptor" class="cn.itcast.aop.ExpessionInterceptor" />
			
			<!-- 声明自定义拦截器栈 -->
			<interceptor-stack name="expessionStack">
                <interceptor-ref name="defaultStack"/>
                
                <!-- 配置使用自定义拦截器 -->
                <interceptor-ref name="expessionInterceptor"/>
                
            </interceptor-stack>
		</interceptors>
		
		<!-- 配置修改struts2框架运行时，默认执行的是自定义拦截器栈 -->
		<default-interceptor-ref name="expessionStack" />
	
	
	