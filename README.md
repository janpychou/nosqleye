# NOSQL EYE
nosql数据库监控工具，目前实现了对Redis、MongoDB的监控功能。

## 版本更新：
### 1.5：
1、新增数据查询功能，可根据key查询对应数据，对string/hash/set/zset/list都做了相应支持；
2、支持统计其他db的监控信息，之前只对db0进行监控统计；
### 1.4：
初始版本，完成对Redis、MongoDB监控基础功能。

## 演示地址：
http://120.77.46.146:7004
登录用户名、密码:admin/admin

另：演示数据查询的功能可以用username作为key进行查询。
## 预览
![图片描述](http://112.74.163.112:8085/tmp/11.png)
![图片描述](http://112.74.163.112:8085/tmp/22.png)
![图片描述](http://112.74.163.112:8085/tmp/33.png)
![图片描述](http://112.74.163.112:8085/tmp/44.png)
![图片描述](http://112.74.163.112:8085/tmp/55.png)
![图片描述](http://112.74.163.112:8085/tmp/66.png)
![图片描述](http://112.74.163.112:8085/tmp/77.png)
## 安装环境：

推荐：centos7（6.*也可以）、MySQL5.7、JDK8

## 安装步骤：

1、安装初始数据，在MySQL数据库上新建nosql_eye数据库，导入build/nosql_eye.sql文件。新建数据库账户:dev，密码：123456

2、将build/nosql-eye-xx.jar传输到服务器，java -jar nosql-eye-xx.jar启动应用即可。如需在后台启动请使用：nohup java -jar nosql-eye-xx.jar > /dev/null 2>&1 &

## 该项目使用的技术：

### 前端：
* bootstrap3
* jquery1.11
* ECharts3
* vis

### 后端：
* springboot 1.5.4
* druid1.0
* mybatis3.4
* ehcache2.10
* fastjson1.2
* logback1.1

### 数据库：
* MySQL5.7


## 联系：
360841519@qq.com
