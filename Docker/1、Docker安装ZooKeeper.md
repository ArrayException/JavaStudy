# Docker安装并使用zookeeper & 安装zkui

## 一、安装zookeeper

### 1、拉取zookeeper镜像

```bash
docker pull zookeeper
```

### 2、查看镜像(查看zookeeper镜像是否拉去成功)

```bash
docker images
```

```bash
docker inspect [镜像ID]
```

### 3、启动zookeeper容器

启动zookeeper容器

- -p 2181:2181 将容器的2181端口映射到宿主机的2181端口
- --name local-zookeeper 容器名为 local-zookeeper

```bash
docker run -d -p 2181:2181 --name local-zookeeper --restart always [镜像ID]
```

二、安装zkui
zkui是Zookeeper的一个UI仪表板，它允许对Zookeeper进行CRUD操作

github下载地址: https://github.com/DeemOpen/zkui

### 1、下载zkui项目

前往https://github.com/DeemOpen/zkui clone下项目

### 2、使用maven打包项目

```bash
mvn clean install -DskipTests
```

### 3、创建docker数据卷

```bash
docker volume create zkui
```

数据卷宿主机映射地址:
`cd /var/lib/docker/volumes/zkui/_data`

### 4、项目部署

把根目录下的文件config.cfg（里面是相关的配置，这个看具体的情况，但是里面配置的zookeeper必须启动），拷贝到与当前jar同目录写下，在cmd窗口中执行命令：

- 上传config.cfg 和 zkui-2.0-SNAPSHOT-jar-with-dependencies.jar 到docker数据库

```bash
java -jar zkui-2.0-SNAPSHOT-jar-with-dependencies.jar &
```

或者后台挂起启动

```bash
nohup java -jar zkui-2.0-SNAPSHOT-jar-with-dependencies.jar &
```
  