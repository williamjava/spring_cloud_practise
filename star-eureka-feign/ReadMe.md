该应用用于消费应用star-compute-service提供的服务。

feign模块用于实现服务消费。

核心注解：@EnableFeignClients，@FeignClient

Feign中使用断路器：自带Hystrix
	a.在注解@FeignClient中通过指定fallback属性定义回调类
	b.创建回调类，实现@FeignClient的接口