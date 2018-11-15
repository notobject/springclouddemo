# Spring Cloud Demo

注册中心： http://www.notobject.com:8761
微代理： http://www.notobject.com:8090/api/user/getUserInfo/1
用户服务：http://www.notobject.com:8081/getUserInfo/2
设置服务：http://www.notobject.com:8081/getSettings/1

## 简单介绍

学习Spring Cloud时写的demo,分为5个模块：

- 注册中心: register-server
- 配置中心: config-server
- 微代理: proxy-zuul-server
- Demo微服务: user-service
- Demo为服务: settings-servcie

## 本地运行

1. 将项目导入IDEA
2. 修改各模块的配置文件中的配置中心地址和服务注册地址为localhost
3. 新建一个git仓库用作配置中心的存储库，并修改config-server的配置文件中的仓库地址。
4. 在新建的git仓库中新建所需的配置文件（参考https://github.com/notobject/config-center）
5. 依次直接运行config-server -> register-server -> proxy-zuul-server -> demo-user-service -> demo-settings-service
6. 浏览器访问： http://localhost:8090/api/user/getUserInfo/1 

## Docker部署

1. 将项目导入IDEA
2. 准备一台安装了docker engine 的Linux云服务器或虚拟机。
3. 设置本地的windows环境变量 DOCKER_HOST=tcp://装有docker的linux主机:2375
4. 新建一个git仓库用作配置中心的存储库，并修改config-server的配置文件中的仓库地址。
5. 在新建的git仓库中新建所需的配置文件（参考https://github.com/notobject/config-center）
5. 对5个模块依次执行mvn clean package docker:build
6. 进入linux服务器，依次执行（确保相应的端口暴露）： 
  - docker run --name config-server -p 8888:8888 -t image/config-server -d
  - docker run --name register-server -p 8761:8761 -t image/register-server -d
  - docker run --name proxy-zuul-server -p 8090:8090 -t image/proxy-zuul-server -d
  - docker run --name demo-user-service -p 8081:8081 -t image/demo-user-service -d
  - docker run --name demo-settings-service -p 8082:8082 -t image/demo-settings-service -d
  
7. 浏览器访问http://xxx:8090/api/user/getUserInfo/1 

