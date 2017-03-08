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

##Dockerfile
Dockfile是一种被Docker程序解释的脚本，Dockerfile由一条一条的指令组成，每条指令对应Linux下面的一条命令。Docker程序将这些Dockerfile指令翻译真正的Linux命令。

###Dockerfile之FROM
支持的格式：

* `FROM <image>`
* `FROM <image>:<tag>`
* `FROM <image>@<digest>`

FROM指令必须指定且需要在Dockerfile其他指令的前面，指定的基础image可以是官方远程仓库中的，也可以位于本地仓库。后续的指令都依赖于该指令指定的image。当在同一个Dockerfile中建立多个镜像时，可以使用多个FROM指令。

###Dockerfile之VOLUME
支持的格式：

* `VOLUME ["/data"]` 

使容器中的一个目录具有持久化存储数据的功能，该目录可以被容器本身使用，也可以共享给其他容器。当容器中的应用有持久化数据的需求时可以在Dockerfile中使用该指令。

###Dockerfile之ADD
支持的格式：

- `ADD <src>... <dest>`
- `ADD ["<src>",... "<dest>"]`

从src目录复制文件到容器的dest。其中src可以是Dockerfile所在目录的相对路径，也可以是一个URL，还可以是一个压缩包。

注意：
1. src必须在构建的上下文内，不能使用例如：`ADD ../somethine /something` ，因为`docker build` 命令首先会将上下文路径和其子目录发送到docker daemon
2. 如果src是一个URL，同时dest不以斜杠结尾，dest将会被视为文件，src对应内容文件将会被下载到dest
3. 如果src是一个URL，同时dest以斜杠结尾，dest将被视为目录，src对应内容将会被下载到dest目录
4. 如果src是一个目录，那么整个目录其下的内容将会被拷贝，包括文件系统元数据
5. 如果文件是可识别的压缩包格式，则docker会自动解压

###Dockerfile之RUN
支持的格式：

* `RUN <command>` 
* 或 `RUN ["executable", "param1", "param2"]`。

`RUN <command>` 在shell终端中运行命令，在Linux中默认是`/bin/sh -c` 在Windows中是 `cmd /s /c`
`RUN ["executable", "param1", "param2"]` 使用exec执行。指定其他终端可以通过该方式操作，例如：`RUN ["/bin/bash", "-c", "echo hello"]` ，该方式必须使用["]而不能使用[']，因为该方式会被转换成一个JSON 数组。

###Dockerfile之EXPOSE
格式为：

* `EXPOSE <port> [<port>...]`

为Docker容器设置对外的端口号。在启动时，可以使用-p选项或者-P选项。

示例：

```dockerfile
# 映射一个端口示例
EXPOSE port1
# 相应的运行容器使用的命令
docker run -p port1 image
# 也可以使用-P选项启动
docker run -P image

# 映射多个端口示例
EXPOSE port1 port2 port3
# 相应的运行容器使用的命令
docker run -p port1 -p port2 -p port3 image
# 还可以指定需要映射到宿主机器上的某个端口号  
docker run -p host_port1:port1 -p host_port2:port2 -p host_port3:port3 image
```

###Dockerfile之ENTRYPOINT
支持的格式：

* `ENTRYPOINT ["executable", "param1", "param2"]`
* `ENTRYPOINT command param1 param2`

指定Docker容器启动时执行的命令，可以多次设置，但是只有最后一个有效。
