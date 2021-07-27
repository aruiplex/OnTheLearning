# MYSQL

### 远程连接

版本: mysql 8.0 (注意版本号, 因为8.0与5.7之间已经出现了很多不一样的地方) .



对于新版mysql, 需要改变一下配置, 配置文件在`/etc/mysql/mysql.conf.d/mysqld.cnf` :



修改*bind-address*: 

```
[mysqld]
bind-address = 0.0.0.0
```

重启 **mysql** server

```sql
sudo service mysql restart
```



### 新建用户

这里是*root*用户会有点问题, 最好是别的用户. *root*本来就不是好习惯.

```sql
CREATE USER '用户'@'%' IDENTIFIED BY '密码';
GRANT ALL PRIVILEGES ON *.* TO '用户'@'%';
flush privileges;
```

如果必须是*root*用户:

```sql
use mysql;
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
UPDATE mysql.user SET host='%' WHERE user='root';
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'ThePassword';
```



### mysql dump & source

1. mysql数据导出:

    ```
    mysqldump > {filename}
    ```

2. mysql 数据导入:

    在 mysql 中进行:

    ```
    use database;
    source {mysql};
    ```

    