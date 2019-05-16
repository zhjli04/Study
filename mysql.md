## 逻辑架构图
![](/0d2070e8f84c4801adbfa03bda1f98d9.png "")    

- 连接器    
连接器负责跟客户端建立连接、获取权限、维持和管理连接。    
- 查询缓存    
MySQL 拿到一个查询请求后，会先到查询缓存看看，之前是不是执行过这条语句。之前执行过的语句及其结果可能会以 key-value 对的形式，被直接缓存在内存中。MySQL 8.0 版本直接将查询缓存的整块功能删掉了。    
- 优化器    
优化器是在表里面有多个索引的时候，决定使用哪个索引；或者在一个语句有多表关联（join）的时候，决定各个表的连接顺序。    
- 执行器    
开始执行的时候，要先判断一下你对这个表 T 有没有执行查询的权限，如果没有，就会返回没有权限的错误。    
## redo-log-binlog
- redo log 是 InnoDB 引擎特有的,binlog 是 MySQL 的 Server 层实现的,所有引擎都可以使用.    
- redo log 是物理日志，记录的是“在某个数据页上做了什么修改”；binlog 是逻辑日志，记录的是这个语句的原始逻辑，比如“给 ID=2 这一行的 c 字段加 1 ”。    
- redo log 是循环写的，空间固定会用完；；binlog 是可以追加写入的。“追加写”是指 binlog 文件写到一定大小后会切换到下一个，并不会覆盖以前的日志。        
sql语句查询流程    


        mysql> create table T(ID int primary key, c int);
        mysql> update T set c=c+1 where ID=2;    
        
![](/2e5bff4910ec189fe1ee6e2ecc7b4bbe.png "流程")
