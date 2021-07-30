# ssm_test
使用Spring + Mybatis + SpringMVC搭建的后台项目

## 环境准备

1.IntelliJ IDEA

2.Maven

https://maven.apache.org/

3.MYSQL

https://www.mysql.com/

4.Tomcat

http://tomcat.apache.org/

5.JDk

https://www.oracle.com/java/technologies/javase-downloads.html

## SSM框架简介

无论你是前端，APP，后端开发工程师，搭建一个自己的后台对于学习都是很有帮助的，本文是作者搭建SSM后端环境的记录，阅读完本文你也可以快速搭建一个属于自己的后端代码。

**SSM框架**是Spring MVC ，Spring和Mybatis**框架**的整合，是标准的MVC模式，将整个系统划分为View层，Controller层，Service层，DAO层四层，使用Spring MVC负责请求的转发和视图管理，Spring实现业务对象管理，Mybatis作为数据对象的持久化引擎。

## 数据库配置

首先我们创建一个数据库和表。

创建数据库的SQL

```
CREATE DATABASE time_manager_app
```

创建数据表的SQL

```use time_manager_app;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(8) NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

向数据表中插入一条数据

```
INSERT INTO `user` VALUES ('1', '1');
```

## 创建工程

现在我们打开IDEA创建我们的maven工程

File->New->Project

![w8nIN6.png](https://img-service.csdnimg.cn/img_convert/a532b46b6508be5591d4daf00eb84c3a.png)

选择maven,选中红框中的选项，点击Next

![w8ukuj.png](https://img-service.csdnimg.cn/img_convert/df76a7ef738deb1180bde757f3c24fef.png)

红框中的两个选项随便输入，点击Next

![w8ut56.png](https://img-service.csdnimg.cn/img_convert/fc99b00fb83ac2d03250cb310f00f51c.png)

红框中选择本地安装的maven软件的位置，点击Next

![w8uzL9.png](https://img-service.csdnimg.cn/img_convert/1bd0c0fabe4fd85eb66438f8229c89ea.png)

点击finish

[![w8KlJf.md.png](https://img-service.csdnimg.cn/img_convert/9ca6f636b4a5c9930348d62c1bcaf9b5.png)](https://imgchr.com/i/w8KlJf)

现在我们的maven工程就创建好了

![w8K0YV.png](https://img-service.csdnimg.cn/img_convert/41b9a6ad71bfdeee1f2dc90346d870c7.png)



接下来我们要创建一些工程需要的文件夹

右键选择SRC->NEW->Directory

![w8Kbmd.png](https://img-service.csdnimg.cn/img_convert/b93feefd837efae0784b872e2eed67df.png)

创建好的文件目录如下

![w8MEt0.png](https://img-service.csdnimg.cn/img_convert/82b6d83db9d0275087e67f34ff5af57e.png)

右键JAVA将它设置为Source Root

![w8MrNt.png](https://img-service.csdnimg.cn/img_convert/b488058302f2a9446d391d7959125566.png)

右键resource将它设置为Resources Root

![w8MzU1.png](https://img-service.csdnimg.cn/img_convert/a37a4966e865a377ae0084147fdd1bb3.png)

工程创建完毕，接下来我们编写我们需要的配置文件

## 配置文件编写

首先我们在POM.XML中添加我们需要的依赖包

注意，复制时从备注里的copy开始,复制到copy结束，不要整个文件复制

````
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ssmtest</groupId>
    <artifactId>ssmtest</artifactId>
    <version>1.0-SNAPSHOT</version>
      <!--从这里开始copy -->
    <!-- 用来设置版本号 -->
    <properties>
        <spring.version>4.2.4.RELEASE</spring.version>
        <mybatis.version>3.2.8</mybatis.version>
        <slf4j.version>1.7.12</slf4j.version>
        <log4j.version>1.2.17</log4j.version>
        <druid.version>1.0.9</druid.version>
    </properties>
  
    <!-- 用到的jar包 -->
    <dependencies>
        <!-- 单元测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <!-- 表示开发的时候引入，发布的时候不会加载此包 -->
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.6.8</version>
        </dependency>
        <!-- spring框架包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-oxm</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- spring框架包 -->
        <!-- mybatis框架包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.2.2</version>
        </dependency>
        <!-- mybatis框架包 -->
        <!-- 数据库驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.35</version>
        </dependency>
        <!-- 导入dbcp的jar包，用来在applicationContext.xml中配置数据库 -->
        <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
        <!-- jstl标签类 -->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!-- log -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>

        <!--加入对json转换-->
        <!-- JSON: jackson -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.jr</groupId>
            <artifactId>jackson-jr-all</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.46</version>
        </dependency>
        <dependency>
            <groupId>c3p0</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.1.2</version>
            <type>jar</type>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>jackwu</finalName>
        <!-- java编译插件,如果maven的设置里配置好jdk版本就不用 -->
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        </plugins>

        <!--打包配置文件-->
        <resources>
            <resource>
                <directory>src\main\resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                    <include>**/*.tld</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src\main\java</directory>
                <excludes>
                    <exclude>**/*.java</exclude>
                </excludes>
            </resource>
        </resources>
    </build>
    <!--copy在这里结束 -->

</project>
````

PS:如果你的网络环境不好，Maven下载依赖包需要一段时间，不要着急，继续接下来的配置就可以了

接下来我们在WEB-INF目录下创建web.xml

web.xml内容如下，整个copy就可以

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!-- 配置加载类路径的配置文件 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:applicationContext.xml</param-value>
    </context-param>

    <!-- 配置监听器 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <listener>
        <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
    </listener>

    <!-- 解决中文乱码过滤器 -->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>


    <!-- 前端控制器（加载classpath:springmvc.xml 服务器启动创建servlet） -->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 配置初始化参数，创建完DispatcherServlet对象，加载springmvc.xml配置文件 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <!-- 服务器启动的时候，让DispatcherServlet对象创建 -->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>



    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>default.html</welcome-file>
        <welcome-file>default.htm</welcome-file>
        <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>
</web-app>

```

接着我们在resources文件夹下创建applicationContext.xml

同样内容整个复制

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!-- 开启注解扫描，管理service和dao -->
    <context:component-scan base-package="service">
    </context:component-scan>
    <context:component-scan base-package="dao">
    </context:component-scan>

    <context:property-placeholder location="classpath:db.properties"/>
    <!-- 配置连接池 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
    <!-- 把交给IOC管理 SqlSessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>

    </bean>
    <!-- 扫描dao接口 -->
    <bean id="mapperScanner" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="dao"/>
    </bean>

    <!-- 配置Spring的声明式事务管理 -->
    <!-- 配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>
```

接着我们在resource文件夹下创建spring-mvc.xml

同样内容整个复制

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/mvc
           http://www.springframework.org/schema/mvc/spring-mvc.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd
           http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop.xsd
           ">

    <!-- 扫描controller的注解，别的不扫描 -->
    <context:component-scan base-package="controller">
    </context:component-scan>

    <!-- 配置视图解析器 -->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- JSP文件所在的目录 -->
        <property name="prefix" value="/pages/" />
        <!-- 文件的后缀名 -->
        <property name="suffix" value=".jsp" />
    </bean>


    <!-- 开启对SpringMVC注解的支持 -->
    <mvc:annotation-driven />

    <!--
        支持AOP的注解支持，AOP底层使用代理技术
        JDK动态代理，要求必须有接口
        cglib代理，生成子类对象，proxy-target-class="true" 默认使用cglib的方式
    -->

    <!--
        支持AOP的注解支持，AOP底层使用代理技术
        JDK动态代理，要求必须有接口
        cglib代理，生成子类对象，proxy-target-class="true" 默认使用cglib的方式
    -->
    <aop:aspectj-autoproxy proxy-target-class="true"/>
    <!-- 输出对象转JSON支持 -->
    <bean
            class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
        <property name="messageConverters">
            <list>
                <bean
                        class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                    <property name="supportedMediaTypes">
                        <list>
                            <value>text/html;charset=UTF-8</value>
                            <value>text/plain;charset=UTF-8</value>
                            <value>application/json;charset=UTF-8</value>
                        </list>
                    </property>
                </bean>
            </list>
        </property>
    </bean>

</beans>
```

接着我们在resource文件夹下创建db.properties

同样内容整个复制

```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/time_manager_app?characterEncoding=utf-8
jdbc.username=root
jdbc.password=root
```

现在我们的工程文件结构是这样的

![w83UPI.png](https://img-service.csdnimg.cn/img_convert/673ee16c81dc9df16572c721225c8da8.png)

接下来我们要编写我们的java代码

## Java代码编写

首先我们创建几个需要的文件夹

![w889dH.png](https://img-service.csdnimg.cn/img_convert/1fda71555b5a1029309e6879843cce88.png)



接着我们在相应的文件夹下创建我们的java文件

文件结构如下

![w8GF74.png](https://img-service.csdnimg.cn/img_convert/c85c10b5fb2b5063ec76d3680b932909.png)

每个文件下的代码如下

UserController

```
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find.do")
    @ResponseBody
    public Object findAll(){
        Object a = userService.findAll();
        System.out.println(a);
        return  a;
    }
}
```

UserDao

```
package dao;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    public List<User> findAll();
}

```

User

```
package pojo;

public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

UserServiceImpl

```
package service.impl;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<User> findAll(){
        return  userDao.findAll();
    }
}
```

UserService

```
package service;

import pojo.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
}
```

到这里代码应该是没有错误的.如果有错误，可能是依赖包没有下载好，等待一下

接下来我们配置tomcat

## 配置tomcat

点击idea右上角的位置，接着点击edit

![w8t2vt.png](https://img-service.csdnimg.cn/img_convert/c306eeb459718bfbc3eef58ceee010a2.png)

按顺序点击红色框的位置

![w8tOK0.png](https://img-service.csdnimg.cn/img_convert/54dd4cf16fccf1b84561018832fcb75f.png)



在红框处选择tomcat版本

![w8NAr6.png](https://img-service.csdnimg.cn/img_convert/20fb3b0c0c8f400b811abf9a9754d96c.png)

接着配置我们的war包，点击红色框处

![w8NmIe.png](https://img-service.csdnimg.cn/img_convert/e9690ba9e3e0bbbb0a6ad7c61ec93173.png)

选择第二个

![w8N8qf.png](https://img-service.csdnimg.cn/img_convert/bc4920656bf8449d75c2be1c195c97f1.png)

清空application context中的内容，点击apply

![w8NUiQ.png](https://img-service.csdnimg.cn/img_convert/3c380505bee594a5cb42312fbc1f82ce.png)

NO NO NO配置中间我们出现了一个问题

应该把resource文件夹更名为resources    Sorry

正确的工程路径如下

![w8w7jA.png](https://img-service.csdnimg.cn/img_convert/a14c1645bdb676060d2255aae361e3fd.png)

## 启动程序

接下来我们要启动我们的程序，测试是否配置成功

按顺序点击红框处

![w8N5sx.png](https://img-service.csdnimg.cn/img_convert/6d6cf9c00830d878ba95f44cdc1461bd.png)

等待打包成功，会出现target文件夹，控制台log如下

![w8UGlR.png](https://img-service.csdnimg.cn/img_convert/d2e2c97bb0b410aa98df2c314b3e5425.png)

接着点击绿色箭头，启动程序

![w8aQDP.png](https://img-service.csdnimg.cn/img_convert/1b849e464583e19d1e74c6e7e34b6314.png)

## 测试

打开我们的浏览器，输入http://localhost:8080/user/find.do

![w80FH0.png](https://img-service.csdnimg.cn/img_convert/b9522872bd99268af266145b2926bb26.png)

Amazing数据库中的一条数据已经成功返回了，到此我们的SSM工程配置成功。



*师者，所以传道授业解惑也，教师节快乐*