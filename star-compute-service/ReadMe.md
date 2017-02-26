该应用作为一个服务提供者，提供的服务会自动添加到star-eureka-server应用创建的服务注册发现中心。

核心注解：@EnableDiscoveryClient(激活Eureka中的DiscoveryClient实现，用于发现Eureka服务中心的服务)

加入消息总线：
	a.添加依赖
	b.配置RabbitMQ连接信息
	c.注释使用配置属性的地方，增加注解：@RefreshScope
	d./bus/refresh刷新配置
	