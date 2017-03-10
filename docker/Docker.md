#Docker

###什么是Docker?
一种基于LXC的轻量级容器技术。一次打包，任何环境，任何时间运行！

###基于MacOS安装Docker
* 安装VirtualBox
* 安装boot2docker brew install boot2docker
* 安装docker brew install docker
* boot2docker初始化和启动 boot2docker init；boot2docker up

###创建自己的第一个容器
* 进入docker客户端 boot2docker ssh
* 查看本地所有镜像 docker images
* 从公共镜像库搜索一个镜像 docker search ubuntu
* 从公共镜像库拉取一个镜像到本地 docker pull ubuntu(拉去的是最新的版本latest)
* 用拉去的这个镜像运行自己的第一个Docker容器 docker run -i -t ubuntu
