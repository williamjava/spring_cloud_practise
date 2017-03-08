#My practise on SpringCloud, based on SpringBoot.

It's easy for us to make a micro-service architecture using Spring Cloud.

Here we need to know that what's micro-service. Just make it easy, micro-service is a concept. Its purpose is to make a complicate application into many small services. Each service can be built,maintained and extended alone. In my opinion, it's awesome.

As we know, if we don't have Spring Cloud, I think it's not easy to make a micro-service architecture. But now it's easy for us to do it.

##How to test presure performance?
use apache tool ab.
ab -c 5 -n 20 http://localhost:7777/add

##Docker Compose
Docker Compose 是一个用于定义和运行多容器的Docker应用的工具。使用Compose，你可以在一个配置文件（yaml格式）中配置你应用的服务，然后使用一个命令，即可创建并启动配置中引用的所有服务

1.如何安装？
sudo pip install docker-compose

2.如何使用？
启动：docker-compose up
查看已经创建的容器实例：docker-compose ps
创建多个容器实例：docker-compose scale [compose container name]=3
