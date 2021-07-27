# minio

一个对象数据库(cos), 很好用的开源软件, 有很高级但是我当前还没有用到的功能: "灾容", "主从备份"什么的.





先是启动程序:

从环境变量里配置`USER`和`PASSWORD`:

> 从环境变量里配置要紧的隐私信息这种做法还挺多的, 挺常见的.

```bash
export MINIO_ROOT_USER=minio
export MINIO_ROOT_PASSWORD=minio13 
minio server /data
```









我先在这记录一个小问题:



### 获取对象的URL连接:

直接点分享这样的是有期限的:

![image-20210727021310171](C:\Users\aruix\AppData\Roaming\Typora\typora-user-images\image-20210727021310171.png)

并且在一个桶(*bucket*)在新建的时候的*policy*是私有读写, 所以想要分享的话, 要先改变*policy*:

![image-20210727021202630](C:\Users\aruix\AppData\Roaming\Typora\typora-user-images\image-20210727021202630.png)

之后的 `URL+ backet name + object name` 就是对象的URL了.