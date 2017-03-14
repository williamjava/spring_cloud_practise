#Docker-Machine
Docker Machine是一个简化Docker安装的命令行工具，通过一个简单的命令行即可在相应的平台上安装Docker，比如VirtualBox、 Digital Ocean、Microsoft Azure。Docker官方是这样介绍Machine的初衷的：
```
之前，Docker的安装流程非常复杂，用户需要登录到相应的主机上，根据官方的安装和配置指南来安装Docker，并且不同的操作系统的安装步骤也是不一样的。而有了Machine后，不管是在笔记本、虚拟机还是公有云实例上，用户仅仅需要一个命令....当然那你需要先安装Machine。
```

##如何安装？
brew install docker-machine

##具体使用
```
1.创建Docker主机：docker-machine create nb-consul --driver virtualbox
2.设置环境变量：docker-machine env nb-consul
3.SSH到Docker主机：docker-machine ssh nb-consul
```

##完整命令列表
```
help 查看帮助信息

active 查看活动的Docker主机

config 输出连接的配置信息

create 创建一个Docker主机

env 显示连接到某个主机需要的环境变量

inspect 输出主机更新信息

ip 获取Docker主机地址

kill 停止某个Docker主机

ls 列出所有管理的Docker主机

regenerate-certs 为某个主机重新成功TLS认证信息

restart 重启Docker主机

rm 删除Docker主机

scp 在Docker主机之间复制文件

ssh SSH到主机上执行命令

start 启动一个主机

status 查看一个主机状态

stop 停止一个主机

upgrade 更新主机Docker版本为最新

url 获取主机的URL
```
