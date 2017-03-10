#My practise on SpringCloud, based on SpringBoot.

It's easy for us to make a micro-service architecture using Spring Cloud.

Here we need to know that what's micro-service. Just make it easy, micro-service is a concept. Its purpose is to make a complicate application into many small services. Each service can be built,maintained and extended alone. In my opinion, it's awesome.

As we know, if we don't have Spring Cloud, I think it's not easy to make a micro-service architecture. But now it's easy for us to do it.

##How to test presure performance?
use apache tool ab.
ab -c 5 -n 20 http://localhost:7777/add

##SpringCloud项目集成Docker

###1.修改pom.xml
<properties>
		<!-- 指定要生成Docker镜像的前缀名称 -->
		<docker.image.prefix>williamjian</docker.image.prefix>
		<!-- 指定Docker Maven插件的版本 -->
		<docker.plugin.version>0.4.13</docker.plugin.version>
	</properties>
  
  <build>
		<plugins>
			<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>docker-maven-plugin</artifactId>
				<version>${docker.plugin.version}</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>build</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<!-- 定义Docker镜像的名称 -->
					<imageName>${docker.image.prefix}/${project.artifactId}</imageName>
					<!-- 指定Dockerfile所在目录 -->
					<dockerDirectory>${project.basedir}/src/main/docker</dockerDirectory>
					<!-- 指定资源，这里是我们生成的jar，将用于启动到容器 -->
					<resources>
						<resource>
							<targetPath>/</targetPath>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
				</configuration>
			</plugin>
		</plugins>
	</build>
  
###2.Docerfile文件编写
```
FROM java:8
VOLUME /tmp
ADD star-eureka-server-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 1314
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
```

###3.docker-compose.yml文件编写
```
eureka-server: 
  image: williamjian/star-eureka-server
  ports:
   - "1314:1314"
```

###4.maven打包生成本地Docker镜像
项目更目录下：mvn clean install

###5.使用Docker-compose启动容器
docker目录下(有docker-compose.yml的目录)：docker-compse up
