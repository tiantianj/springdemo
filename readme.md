# Spring 框架练习示例

## 项目一：PostManage
> 一个简单的发帖回帖程序，使用Spring + Spring MVC + JDBC实现。
> 知识点
> * IoC/DI
> * AOP 
> * 声明式事务
> * Spring Test
> * Spring + JDBC
> * 。。。

## Spring整合JDBC

### 数据访问异常体系
1. 可以导致抛出SQLException的常见问题包括：
    - 应用程序无法连接数据库
    - 要执行的SQL语句存在语法错误
    - 查询所使用的表/列名不存在
    - 试图插入或更新的数据违反数据库约束
2. Spring提供了一套与平台无关的持久化异常

### 配置数据源
- 通过JDBC驱动程序定义的数据源——没有池
- 通过JNDI查询的数据源
- 连接池的数据源——推荐
    - Apache Commons DBCP
    - c3p0

### 使用JDBC模板
-JdbcTemplate：简单的JDBC数据库访问和基于索引(?)参数的查询
    - query() 查询获取集合对象
    - queryForObject() 查询获取单个对象
    - update() 执行增删改语句
    - 注意：查询相关操作需要传入映射解析逻辑RowMap<T>的实现
-NamedParameterJdbcTemplate：增加基于命名参数的查询