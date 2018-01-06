该应用作为一个服务提供者，提供的服务会自动添加到star-eureka-server应用创建的服务注册发现中心。

核心注解：@EnableDiscoveryClient(激活Eureka中的DiscoveryClient实现，用于发现Eureka服务中心的服务)

加入消息总线：
	a.添加依赖
	b.配置RabbitMQ连接信息
	c.注释使用配置属性的地方，增加注解：@RefreshScope
	d./bus/refresh刷新配置
	
加入热部署：
	方式一：使用springloaded，具体配置参见pom.xml；该方式可以做到，修改类文件内容后，不需要重启服务就可以看到最新的效果；启动方式：项目根目录执行mvn spring-boot:run，也可以在开发工具中进行运行配置。
	方式二：使用spring-boot-devtools，具体配置参见pom.xml；该方式可以做到，修改类文件内容后，自动重启服务，少去了我们开发过程中每次手动重启服务；
	注意：不管是采用什么方式，都需要设置为自动编译！
	