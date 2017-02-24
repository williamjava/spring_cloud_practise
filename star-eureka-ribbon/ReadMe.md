该应用用于消费应用star-compute-service提供的服务。

Ribbon模块用于实现服务消费。

核心注解：@EnableDiscoveryClient，@LoadBalanced

Ribbon中使用断路器：Hystrix
	a.添加Hystrix依赖
	b.启动类中通过@EnableCircuitBreaker开启断路器功能
	c.改造原有服务的消费模式，使用注解@HystrixCommand指定回调函数