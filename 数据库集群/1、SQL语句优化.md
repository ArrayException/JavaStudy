# SQL优化

## 一、SQL语句优化

### 1、不要将SELECT子句写成 SELECT *

如: 我们要查询员工表(t_emp)

```sql
SELECT * FROM t_emp;
```

### 2、谨慎使用模糊查询

模糊查询条件前后都带%，会导致不使用索引

```sql
SELECT ename FROM t_emp WHERE ename LIKE '%S%';
```

可优化为:

```sql
SELECT ename FROM t_emp WHERE ename LIKE 'S%';
```

### 3、对ORDER BY排序的字段设置索引

### 4、少用IS NULL

```sql
  SELECT ename FROM t_emp WHERE comm IS NULL; #不使用索引
  SELECT ename FROM t_emp WHERE comm =-1;
```

尽量少用 != 运算符

```sql
  SELECT ename FROM t_emp WHERE deptno!=20; #不使用索引
  SELECT ename FROM t_emp WHERE deptno<20 AND deptno>20;
```

尽量少用 OR 运算符

```sql
  SELECT ename FROM t_emp WHERE deptno=20 OR deptno=30; #不使用索引
  SELECT ename FROM t_emp WHERE deptno=20 
  UNION ALL
  SELECT ename FROM t_emp WHERE deptno=30;
```

尽量少用 IN 和 NOT IN 运算符

```sql
  SELECT ename FROM t_emp WHERE deptno IN (20,30); #不使用索引
```

可将 IN 替换为 UNION ALL, 优化如下:

```sql  
  SELECT ename FROM t_emp WHERE deptno=20 
  UNION ALL
  SELECT ename FROM t_emp WHERE deptno=30;
```

避免条件语句中的数据类型转换

```sql
  SELECT ename FROM t_emp WHERE deptno='20';
```

在表达式左侧使用运算符和函数都会让索引失效

```sql
  SELECT ename FROM t_emp WHERE salary*12>=100000; #不使用索引
```

优化为:

```sql
  SELECT ename FROM t_emp WHERE salary>=100000/12;
```

```sql
  SELECT ename FROM t_emp WHERE year(hiredate)>=2000; #不使用索引
```

优化为:

```sql
  SELECT ename FROM t_emp WHERE hiredate>='2000-01-01 00:00:00';
```

## 二、SQL参数优化

### 最大连接数

- max_connections是MySQL最大并发连接数，默认值151
- MySQL允许的最大连接数上限是16384
- **实际连接数是最大连接数的85%较为合适**

### 请求堆栈的大小

- back_log是存放执行请求的堆栈大小，默认值是50
- 一般堆栈大小设置成最大连接数的1/3

### 修改并发线程数

- innodb_thread_concurrency代表并发线程数，默认是0
- 并发线程数应该设置为CPU核心数的两倍

### 修改连接超时时间

- wait-timeout是超时时间，单位是秒
- 连接默认超时为8小时，连接长期不用又不销毁，浪费资源

### 数据缓存

- innodb_buffer_pool_size是InnoDB的缓存容量，默认是128M
- InnoDB缓存的大小可以设置为主机内存的70%~80%

## 三、慢查询日志

对慢查询日志会把查询耗时超过规定时间的SQL语句记录下来，利用慢查询日志，定位分析性能的瓶颈，以此针对性优化。

slow_query_log 可以设置慢查询日志的开闭状态

long_query_time 可以规定查询超时的时间，单位是秒

slow_query_log = ON
long_query_time = 1
