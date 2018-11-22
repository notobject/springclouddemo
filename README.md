# Spring Cloud Demo


## 简单介绍

学习Spring Cloud时写的demo,分为5个模块：

- 注册中心: register-server
- 配置中心: config-server
- 微代理: proxy-zuul-server
- Demo微服务: user-service
- Demo微服务: settings-servcie


## 本地运行

1. 将项目导入IDEA
2. 依次进入register-server -> config-server -> proxy-zuul-server -> demo-user-service -> demo-settings-servcie 目录
   执行 mvn clean spring-boot:run -Plocalhost

## 生成jar包
1. 将项目导入IDEA
2. 准备若干服务器（预装好Docker并暴露2375端口）
3. 依次修改各模块的pom文件，将profiles中的ip.address改为你自己的服务器地址
4. 依次修改`application-*.yml` 配置文件，将其中的rabbitMQ连接信息和注册中心地址改成你的服务器地址
5. 对各个模块依次执行：mvn clean package -P server1(这里的server1 表示启动的profile, 部署到不同的服务器，修改这个值即可)
6. 上传jar包到相应的服务器
7. 依次执行 nohup java -jar ./xxxx.jar

## Docker部署

1. 将项目导入IDEA
2. 准备若干服务器（预装好Docker并暴露2375端口）
3. 依次修改各模块的pom文件，将profiles中的ip.address改为你自己的服务器地址
4. 依次修改`application-*.yml` 配置文件，将其中的rabbitMQ连接信息和注册中心地址改成你的服务器地址
5. 对各个模块依次执行：mvn clean docker:build -P server1(这里的server1 表示启动的profile, 部署到不同的服务器，修改这个值即可)
6. 进入服务器执行：docker images 可以看到推送过来的镜像文件 image/***
7. 以运行注册中心为例： docker run --name register-center -p 8761:8761 -t image/register-server --restart=always -d
8. 验证：浏览器访问http://xxx:8761 (xxx为你的服务器地址)

## 我的部署策略

分别准备6台服务器ServerA1，ServerA2, ServerB1,ServerB12， ServerC1，ServerC2， 其中A,B,C表示3个集群:Nginx集群，微服务基础组件集群，微服务系统集群

ServerB1和ServerB2互为对等服务器，注册中心，配置中心以及微代理各都部署一个实例到B1和B2上

ServerA1和ServerA2安装keeplived，并部署Nginx，A1作为Nginx主服务器。A2作为备用服务器。Nginx反向代理对象为B1和B2的proxy-zuul-server地址。

ServerC1和ServerC2部署普通业务微服务。如user-service分别部署一个实例到C1和C2,避免单点故障


## TODO
对于普通的微服务，在启动时采用了随机端口，但是我现在还没有找到怎么在用docker部署的时候，去映射spring boot的随机端口。
如果直接生成jar包执行，则不存在这个问题
