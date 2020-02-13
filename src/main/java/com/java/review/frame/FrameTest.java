package com.java.review.frame;

public class FrameTest {
}

/**
 * 1.什么是Maven？
 *  Maven使用项目对象模型(POM)的概念，可以通过一小段描述信息来管理项目的构建，报告和文档的软件项目管理工具
 * 2.Maven和ANT的区别？
 *  maven&ant同属流行的构建工具
 *  maven的中央仓库和pom.xml文件，中央仓库统一存放了开发用到的各种jar包，要用时只需要添加依赖到pom文件中，maven就会自动下载
 *  ant的build.xml文件。build文件是ant的配置文件，ant依靠它来执行操作，与maven不同的是ant没有固定一条程序链
 *  Maven 拥有约定，只要遵守约定，它就知道你的源代码在哪里；ant没有约定，项目生命周期，它是命令式的
 * 3.Maven仓库是什么？
 *  Maven仓库是基于简单文件系统存储的，集中化管理Java API资源（构件）的一个服务
 *  仓库分为两类：本地仓库和远程仓库
 * 4.Maven的工程类型有哪些？
 *  POM工程：用在父级工程或聚合工程中，用来做jar包的版本控制
 *  JAR工程：将会打包成jar用作jar包使用
 *  WAR工程：网站的打包格式
 * 5.Maven常用命令有哪些？
 *  install、clean、compile、deploy、package
 * 6.ZooKeeper的作用是什么？
 *  ZooKeeper与Eureka一样是服务注册中心，
 *  配置管理、名字服务、分布式锁、集群管理
 *  ZooKeeper遵循CAP的CP，可用性差一些
 *  Eureka遵循CAP的AP，一致性差一些
 *  其中分布式锁主要有3种实现方式：redis、数据库、zookeeper
 * 6.什么是Znode？
 *  在Zookeeper中，znode是一个跟Unix文件系统路径相似的节点，可以往这个节点存储或获取数据
 *  Zookeeper底层是一套数据结构。这个存储结构是一个树形结构，其上的每一个节点，我们称之为“znode”
 *  zookeeper中的数据是按照“树”结构进行存储的
 *  每一个znode默认能够存储1MB的数据
 *  可以使用zkCli命令，登录到zookeeper上，并通过ls、create、delete、get、set等命令操作这些znode节点
 * 7.Znode节点类型有哪些？
 *  PERSISTENT 持久化节点
 *  PERSISTENT_SEQUENTIAL 持久顺序节点
 *  EPHEMERAL 临时节点
 *  EPHEMERAL_SEQUENTIAL 临时自动编号节点
 * 8.什么是Dubbo？
 *  Dubbo是阿里巴巴公司开源的一个高性能优秀的服务框架
 *  远程通讯、集群容错、自动发现
 *  透明化的远程方法调用，就像调用本地方法一样调用远程方法，只需简单配置，没有任何API侵入
 *  软负载均衡及容错机制，可在内网替代F5等硬件负载均衡器，降低成本，减少单点
 *  服务自动注册与发现，不再需要写死服务提供方地址，注册中心基于接口名查询服务提供者的IP地址，并且能够平滑添加或删除服务提供者
 * 9.什么是RPC远程过程调用？
 *  远程过程调用协议
 *  不需要了解底层网络技术的协议的条件下从远程计算机程序上请求服务
 *  RPC协议假定某些传输协议的存在，如TCP或UDP，为通信程序之间携带信息数据
 *  在OSI网络通信模型中，RPC跨越了传输层和应用层
 *  RPC使得开发包括网络分布式多程序在内的应用程序更加容易
 * 10.Dubbo中有哪些角色？
 *  注册中心、发布、订阅、Consumer、provider、容器(spring、springboot)、监控中心
 * 11.Dubbo执行流程什么是？
 *  启动(start)：Spring容器时,自动启动Dubbo的Provider
 *  注册(register)：Dubbo的Provider在启动后自动会去注册中心注册内容：
 *      Provider的 IP
 *      Provider 的端口
 *      Provider 对外提供的接口列表
 *      Dubbo 的版本
 *      访问Provider的协议
 *  订阅(subscribe)：当Consumer启动时,自动去Registry获取到所已注册的服务的信息
 *  通知(notify)：当Provider的信息发生变化时, 自动由Registry向Consumer推送通知
 *  调用(invoke)：Consumer 调用Provider中方法
 *  次数(count)：每隔2分钟,provider和consumer自动向Monitor发送访问次数.Monitor进行统计
 * 12.说说Dubbo支持的协议有哪些？
 *  Dubbo协议(官方推荐协议)
 *  RMI(Remote Method Invocation)协议
 *  Hessian协议
 * 13.Dubbo支持的注册中心有哪些？
 *  Zookeeper(官方推荐)
 *  Multicast
 *  Redis
 *  Simple
 * 14.Session的load和get方法的区别是什么？
 *  如果没有找到符合条件的记录, get方法返回null,load方法抛出异常
 *  get方法直接返回实体类对象, load方法返回实体类对象的代理
 * 15.什么是VSFTPD？
 *  vsftpd 是一个 UNIX 类操作系统上运行的服务器的名字
 *  通常用来存上传的文件和一般的文件
 * 16.什么是Nginx？
 *  Nginx (engine x) 是一个高性能的HTTP和反向代理服务
 * 17.Nginx有哪些作用？
 *  http协议代理
 *  搭建虚拟主机
 *  服务的反向代理
 *  在反向代理中配置集群的负载均衡
 * 18.什么是正向代理？
 *  正向代理，意思是一个位于客户端和原始服务器(origin server)之间的服务器，为了从原始服务器取得内容，客户端向代理发送一个请求并指定目标(原始服务器)，然后代理向原始服务器转交请求并将获得的内容返回给客户端
 *  客户端才能使用正向代理
 * 19.什么是反向代理？
 *  反向代理（Reverse Proxy）方式是指以代理服务器来接受internet上的连接请求，然后将请求转发给内部网络上的服务器，并将从服务器上得到的结果返回给internet上请求连接的客户端，此时代理服务器对外就表现为一个反向代理服务器
 * 20.什么是Redis？
 *  是一个开源的使用ANSI C语言编写、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库
 *  通常被称为数据结构服务器，因为值（value）可以是 字符串(String), 哈希(Map), 列表(list), 集合(sets) 和 有序集合(sorted sets)等类型
 * 21.Redis的特点什么是？
 *  支持多种数据结构
 *  支持持久化操作
 *  支持通过Replication进行数据复制，通过master-slave机制，可以实时进行数据的同步复制，支持多级复制和增量复制，master-slave机制是Redis进行HA的重要手段
 *  单进程请求，所有命令串行执行，并发情况下不需要考虑数据一致性问题
 * 22.Redis数据类型有哪些？
 *  String(字符串)
 *  Hash(hash表)
 *  List(链表)
 *  Set(集合)
 *  SortedSet(有序集合zset)
 * 23.Redis中的常用命令哪些？
 *  incr 让当前键值以1的数量递增，并返回递增后的值
 *  incrby 可以指定参数一次增加的数值，并返回递增后的值
 *  decrby 可以指定参数一次递减的数值，并返回递减后的值
 *  incrbyfloat 可以递增一个双精度浮点数
 *  append 作用是向键值的末尾追加value。如果键不存在则将该键的值设置为value。返回值是追加后字符串的总长度
 *  mget/mset 作用与get/set相似，不过mget/mset可以同时获得/设置多个键的键值
 *  del 根据key来删除value
 *  flushdb 清除当前库的所有数据
 *  hset 存储一个哈希键值对的集合
 *  hget 获取一个哈希键的值
 *  hmset 存储一个或多个哈希是键值对的集合
 *  hmget 获取多个指定的键的值
 *  hexists 判断哈希表中的字段名是否存在 如果存在返回1 否则返回0
 *  hdel 删除一个或多个字段
 *  hgetall 获取一个哈希是键值对的集合
 *  hvals 只返回字段值
 *  hkeys 只返回字段名
 *  hlen 返回key的hash的元素个数
 *  lpush key value向链表左侧添加
 *  rpush key value向链表右侧添加
 *  lpop key 从左边移出一个元素
 *  rpop key 从右边移出一个元素
 *  llen key 返回链表中元素的个数 相当于关系型数据库中 select count(*)
 *  lrange key start end lrange命令将返回索引从start到stop之间的所有元素。Redis的列表起始索引为0。
 *  lrange也支持负索引 lrange nn -2 -1 如 -1表示最右边第一个元素 -2表示最右边第二个元素，依次类推。
 *  lindex key indexnumber 如果要将列表类型当做数组来用，lindex命令是必不可少的。lindex命令用来返回指定索引的元素，索引从0开始，如果是负数表示从右边开始计算的索引，最右边元素的索引是-1。
 *  Lset key indexnumber value 是另一个通过索引操作列表的命令，它会将索引为index的元素赋值为value。
 *  sadd key value 添加一个string元素到,key对应的set集合中，成功返回1,如果元素已经在集合中返回0
 *  scard key 返回set的元素个数，如果set是空或者key不存在返回0
 *  smembers key 返回key对应set的所有元素，结果是无序的
 *  sismember key value 判断value 是否在set中，存在返回1，0表示不存在或者key不存在
 *  srem key value 从key对应set中移除给定元素，成功返回1，如果value 在集合中不存在或者key不存在返回0
 *  zadd key score value 将一个或多个value及其socre加入到set中
 *  zrange key start end 0和-1表示从索引为0的元素到最后一个元素（同LRANGE命令相似）
 *  zrange key 0 -1 withscores 也可以连同score一块输出，使用WITHSCORES参数
 *  zremrangebyscore key start end 可用于范围删除操作
 *  ping 测试redis是否链接 如果已链接返回 PONG
 *  echo value测试redis是否链接 如果已链接返回 echo命令后给定的值
 *  keys * 返回所有的key 可以加*通配
 *  exists key判断string类型一个key是否存在 如果存在返回1 否则返回0
 *  expire key time(s) 设置一个key的过期时间 单位秒。时间到达后会删除key及value
 *  ttl key 查询已设置过期时间的key的剩余时间 如果返回-2表示该键值对已经被删除
 *  persist 移除给定key的过期时间
 *  select dbindex 选择数据库(0-15)
 *  move key dbIndex 将当前数据库中的key转移到其他数据库中
 *  dbsize 返回当前数据库中的key的数目
 *  info 获取服务器的信息和统计
 *  flushdb 删除当前选择的数据库中的key
 *  flushall 删除所有数据库中的所有key
 *  quit 退出连接
 * 24.Redis的配置以及持久化方案有几种？
 *  RDB方式、AOF方式
 * 25.什么是RDB方式？
 *  RDB是对内存中数据库状态进行快照，将Redis在内存中的数据库状态保存到磁盘里面
 *  执行命令手动生成
 *  通过配置自动生成
 * 26.什么是AOF方式？
 *  AOF持久化方式在redis中默认是关闭的，需要修改配置文件开启该方式
 *  AOF：把每条命令都写入文件，类似mysql的binlog日志
 *  AOF方式：是通过保存Redis服务器所执行的写命令来记录数据库状态的文件
 * 27.什么是全文检索？
 *  就是一种将文件中所有文本与检索项匹配的文字资料检索方法
 * 28.什么是Lucene？
 *  Lucene是一个高效的，基于Java的全文检索库
 * 29.什么是Solr？
 *  Solr是一个独立的企业级搜索应用服务器
 * 30.Solr是由哪两个部分构成？
 *  Solr的web服务、Solr的索引库
 * 31.什么是正排索引？
 *  正排索引是以文档的ID为关键字，索引文档中每个字的位置信息，查找时扫描索引中每个文档中字的信息直到找出所有包含查询关键字的文档
 * 32.什么是倒排索引？
 *  对数据进行分析，抽取出数据中的词条，以词条作为key，对应数据的存储位置作为value，实现索引的存储
 * 33.消息服务的应用场景有哪些？
 *  异步处理、应用的解耦、流量的削峰
 * 34.什么是JMS？
 *  JMS（Java Messaging Service）是Java平台上有关面向消息中间件的技术规范，它便于消息系统中的Java应用程序进行消息交换,并且通过提供标准的产生、发送、接收消息的接口，简化企业应用的开发
 * 35.JMS有哪些模型？
 *  PTP模型、Pub-Sub模型
 * 36.什么是JsonP？
 *  跨域是指一个域（网站）下的文档或脚本试图去请求另一个域（网站）下的资源
 * 37.什么是同源策略？
 *  同源是指"协议+域名+端口"三者相同，即便两个不同的域名指向同一个ip地址，也非同源
 *  同源策略/SOP（Same origin policy）是一种约定
 *  如果缺少了同源策略，浏览器很容易受到XSS、CSFR等攻击
 * 38.什么是MyCat？
 *  MyCat是目前最流行的基于java语言编写的数据库中间件
 *  可以把它看作是一个数据库代理，用MySQL客户端工具和命令行访问，配合数据库的主从模式还可实现读写分离
 *  MyCat发展到目前的版本，已经不是一个单纯的MySQL代理了，它的后端可以支持MySQL、SQL Server、Oracle、DB2、PostgreSQL等主流数据库，也支持MongoDB这种新型NoSQL方式的存储
 * 39.什么是纵向切分/垂直切分？
 *  垂直切分：
 *      就是把原本存储于一个库的数据存储到多个库上
 *      减少增量数据写入时的锁对查询的影响
 *      由于单表数量下降，常见的查询操作由于减少了需要扫描的记录，使得单表单次查询所需的检索行数变少，减少了磁盘IO，时延变短
 *  水平切分：
 *      把原本存储于一个表的数据分块存储到多个表上
 *      单表的并发能力提高了，磁盘I/O性能也提高了
 *      如果出现高并发的话，总表可以根据不同的查询，将并发压力分到不同的小表里面
 * 40.简述Tomcat，Apache，JBoss和WebLogic的区别和联系？
 *  Apache：全球应用最广泛的http服务器，免费，出自apache基金组织
 *  Tomcat：应用也算非常广泛的web 服务器，支持部分j2ee，免费，出自 apache基金组织
 *  JBoss：开源的应用服务器，比较受人喜爱，免费（文档要收费）
 *  weblogic：应该说算是业界第一的app server，全部支持j2ee1.4（收费）
 * 41.Tomcat/ WebSphere/WebLogic的作用和特点？
 * 42.B/S和C/S的含义及其区别？
 *  C/S结构，即Client/Server(客户机/服务器)结构，通过将任务合理分配到Client端和Server端，降低了系统的通讯开销，可充分利用两端硬件环境优势
 *  B/S结构，即Browser/Server(浏览器/服务器)结构，是随着Internet技术的兴起，对C/S结构的一种变化或者改进的结构。在这种结构下，用户界面完全通过WWW浏览器实现，一部分事务逻辑在前端实现，但是主要事务逻辑在服务器端实现，节约了开发成本，便于软件维护
 *  C/S是建立在局域网的基础上的。B/S是建立在广域网的基础上的，但并不是说B/S结构不能在局域网上使用
 *  B/S业务扩展简单方便，通过增加页面即可增加服务器功能。C/S的客户端还需要安装专用的客户端软件，不利于扩展
 *  B/S维护简单方便。开发、维护等几乎所有工作也都集中在服务器端，当企业对网络应用进行升级时，只需更新服务器端的软件就可以，这减轻了异地用户系统维护与升级的成本
 *  B/S响应速度不及C/S
 *  B/S用户体验效果不是很理想
 * 43.说说你对容器的理解？
 *  容器也是 java 程序，它的主要作用是为应用程序提供运行环境。容器用来接管安全性、并发性、事务处理、交换到辅助存储器和其它服务的责任
 * 44.为什么要使用连接池？
 *  每次操作都打开一个物理连接，使用完都关闭连接，造成系统性能低下
 * 45.数据库连接池的原理？
 *  传统连接方式：
 *      首先调用Class.forName()方法加载数据库驱动
 *      然后调用DriverManager.getConnection()方法建立连接
 *  连接池技术：
 *      连接池解决方案是在应用程序启动时就预先建立多个数据库连接对象,然后将连接对象保存到连接池中
 *      当客户请求到来时,从池中取出一个连接对象为客户服务
 *      当请求完成时,客户程序调用close()方法,将连接对象放回池中
 *      对于多于连接池中连接数的请求，排队等待
 *      应用程序还可根据连接池中连接的使用率，动态增加或减少池中的连接数
 * 46.MVC模式及其优缺点？
 *  MVC的优点：
 *      降低代码耦合性
 *      有利于分工合作
 *      有利于组件的重用
 *  MVC的缺点：
 *      增加了系统结构和实现的复杂性
 *      视图与控制器间的过于紧密的连接
 *      视图对模型数据的低效率访问
 *      最新技术适配MVC特别难
 * 47.MVC模式完成分页功能的基本思路是什么？
 * 48.常用的Web容器？
 *  Apache、Tomcat
 *  Nginx
 * 49.Java Web开发的Model1和Model2分别指的是什么？
 *  Model1是以页面为中心的Java Web开发，只适合非常小型的应用程序，Model2是基于MVC架构模式的应
 * 50.简单说一下MVC框架？
 *  是为了解决传统MVC模式(jsp+servlet+javabean)一些问题而出现的框架
 *  传统的MVC有web.xml，如果项目太大，web.xml就太庞大并且不能实现模块化管理
 *  一般是和spring整合的，配置文件多
 * 51.简单讲一下SpringMVC的执行流程？
 *  核心控制器捕获请求，查找Handler，执行Handler，选择ViewResolver，通过ViewResoler渲染视图并返回
 * 52.说一下Spring中的两大核心？
 *  IOC(依赖注入)：不创建对象，但是描述创建它们的方式
 *  AOP(面向切面编程)：使用动态代理的设计模式在执行方法前后或出现异常常做加入相关逻辑
 * 53.AOP的作用？
 *  事务处理：执行方法前开启事务，执行完成后关闭事务，出现异常后回滚事务
 *  权限判断：在执行方法前，判断是否具有权限
 *  日志：在执行前进行日志处理
 * 54.讲一下Spring的事务的传播特性？
 *  PROPAGATION_REQUIRED：如果存在一个事务，则支持当前事务，如果当前没有事务，就新建一个事务
 *  PROPAGATION_SUPPORTS：如果存在一个事务，支持当前事务，如果当前没有事务，就以非事务方式执行
 *  PROPAGATION_MANDATORY：如果存在一个事务，支持当前事务，如果当前没有事务，就抛出异常
 *  PROPAGATION_REQUIRES_NEW：新建事务，如果当前存在事务，把当前事务挂起
 *  PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
 *  PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常
 *  PROPAGATION_NESTED：支持当前事务，新增Savepoint点，与当前事务同步提交或回滚
 * 55.什么是ORM？
 *  对象关系映射(Object Relation Mapping，简称ORM)模式是一种为了解决面向对象与关系数据库存在的互不匹配的现象的技术
 *  ORM是通过使用描述对象和数据库之间映射的元数据，将程序中的对象自动持久化到关系数据库中
 *  ORM框架的方法论基于三个核心原则：简单、传达性、精确性
 * 56.简单介绍一下activity？
 *  Activity是一个业务流程管理(BPM)和工作流系统，适用于开发人员和系统管理员，其核心是超快速，稳定的BPMN2的流程引擎，它易于与Spring集成使用
 * 57.什么是MyBatis？
 *  MyBatis是一个可以自定义SQL、存储过程和高级映射的持久层框架
 * 58.Mybatis是如何进行分页的？
 *  可以使用PageHelper
 *  可以使用SQL语句limit
 * 59.什么是MyBatis的接口绑定,有什么好处？
 *  接口映射就是在MyBatis中任意定义接口，灵活定义操作数据库的方法
 * 60.Mybatis能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区别？
 *  Mybatis不仅可以执行一对一、一对多的关联查询，还可以执行多对一，多对多的关联查询，多对一查询
 * 61.使用MyBatis的mapper接口调用时有哪些要求？
 *  Mapper接口方法名和mapper.xml中定义的每个sql的id相同
 *  Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql 的parameterType的类型相同
 *  Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
 *  Mapper.xml文件中的namespace即是mapper接口的类路径
 * 62.MyBatis接口绑定有几种实现方式,分别是怎么实现的?
 *  注解方式、配置xml方式
 * 63.MyBatis的好处是什么？
 *  MyBatis把sql语句从Java源程序中独立出来，放在单独的XML文件中编写，给程序的维护带来了很大便利
 *  MyBatis封装了底层JDBC API的调用细节，并能自动将结果集转换成Java Bean对象，大大简化了Java数据库编程的重复工作
 *  因为MyBatis需要程序员自己去编写sql语句，程序员可以结合数据库自身的特点灵活控制sql语句
 */










