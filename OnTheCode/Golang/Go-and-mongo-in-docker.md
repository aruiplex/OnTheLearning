# Golang and MongoDB



## Docker

这次是在docker里面用的，用下面的形式开启，但是没有说挂在volume，所以container kill 之后是会消失的。

```bash
docker run --name mongodb -d -p 27017:27017 mongo
```

正确的，有硬盘挂在的是这样的：

```
docker run --name mongodb -d -v YOUR_LOCAL_DIR:/data/db mongo
```

为了方便，每次不需要使用cli启动，就出现了docker-compose。

```yml
version: '3'
services:
  mongodb:
    image: mongo
    volumes:
      - /var/db/mongodb:/data/db
    environment:
      - MONGO_INITDB_ROOT_USERNAME=chj
      - MONGO_INITDB_ROOT_PASSWORD=hongchenjin
    ports:
      - 27017:27017
    networks:
      - backend-db

networks:
  backend-db:
    external: true
```



之后会出现网络的问题，如果所有的service都写在docker compose里面的话，docker会很智能的把他们的网连在一起，具体原因在[这里](https://docs.docker.com/compose/networking/)。

> 我就知道我应该耐心把所有docker的doc看完。

如果不是在同一个conpose下，需要用network绑在一起。

```bash
docker network create myNetwork
docker network connect myNetwork web1
docker network connect myNetwork web2
```

绑在一起之后可以去看这个网络的内部结构：

```bash
docker network inspect myNetwork

# output
[
    {
        "Name": "backend-db",
        "Id": "08452a4253bfce96122dc5745a70de92a5bc32775b1f93fae4cac7298186b768",
        "Created": "2021-11-17T22:02:16.238094565+08:00",
        "Scope": "local",
        "Driver": "bridge",
        "EnableIPv6": false,
        "IPAM": {
            "Driver": "default",
            "Options": {},
            "Config": [
                {
                    "Subnet": "172.19.0.0/16",
                    "Gateway": "172.19.0.1"
                }
            ]
        },
        "Internal": false,
        "Attachable": false,
        "Ingress": false,
        "ConfigFrom": {
            "Network": ""
        },
        "ConfigOnly": false,
        "Containers": {
            "63cf7144fd38997906f0985b44a44f40086db76a66e2e91d9164720669f7e684": {
                "Name": "devcontainer_mongodb_1",
                "EndpointID": "8f07ae5aae77d77a9b0f80e4b9aabd4c892a0076e982499b815a985a67f2d535",
                "MacAddress": "02:42:ac:13:00:02",
                "IPv4Address": "172.19.0.2/16",
                "IPv6Address": ""
            },
            "a079ac6e80bf2c95f3c1b49606d5cb96e125a1b950395ecd6063bad13f73846a": {
                "Name": "hardcore_dhawan",
                "EndpointID": "48ed0eb5e570e3692684a7dcb4603ddfbd64e9e375f04fc266a64e4292c445ac",
                "MacAddress": "02:42:ac:13:00:03",
                "IPv4Address": "172.19.0.3/16",
                "IPv6Address": ""
            }
        },
        "Options": {},
        "Labels": {}
    }
]


```

这两个容器一个是mongodb（devcontainer_mongodb_1），一个是vscode（hardcore_dhawan）。我暂时还不清楚为什么会叫这个名字。

直接ping容器的名字或者是ip地址都是可以的。

```bash
$ ping devcontainer_mongodb_1
PING devcontainer_mongodb_1 (172.19.0.2) 56(84) bytes of data.
64 bytes from devcontainer_mongodb_1.backend-db (172.19.0.2): icmp_seq=1 ttl=64 time=0.070 ms
64 bytes from devcontainer_mongodb_1.backend-db (172.19.0.2): icmp_seq=2 ttl=64 time=0.056 ms
64 bytes from devcontainer_mongodb_1.backend-db (172.19.0.2): icmp_seq=3 ttl=64 time=0.054 ms
64 bytes from devcontainer_mongodb_1.backend-db (172.19.0.2): icmp_seq=4 ttl=64 time=0.048 ms
^C
--- devcontainer_mongodb_1 ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 3051ms
rtt min/avg/max/mdev = 0.048/0.057/0.070/0.008 ms

$ ping 172.19.0.2       
PING 172.19.0.2 (172.19.0.2) 56(84) bytes of data.
64 bytes from 172.19.0.2: icmp_seq=1 ttl=64 time=0.073 ms
64 bytes from 172.19.0.2: icmp_seq=2 ttl=64 time=0.048 ms
^C
--- 172.19.0.2 ping statistics ---
2 packets transmitted, 2 received, 0% packet loss, time 1005ms
rtt min/avg/max/mdev = 0.048/0.060/0.073/0.012 ms
```

说明container的hostname已经被docker很智能的修改过了。在连接的时候就不需要直到ip地址，用hostname也就是container name就可。



因为在开发的过程中，如果两个docker容器不能同时起来，需要用external network 连接一起。在host上把network创建好，在docker-compose.yml里面添加上networks配置。

```yml
services:
  mongodb:
    image: mongo
	# ...省略...
    networks:
      - backend-db

networks:
  backend-db:
    external: true
```



> 可以用compose同时起来两个容器，用vscode attach需要开发的容器。也可以实现，是可行的。会自动在容器内部安装一个vs code server。 



##### `bson.M`&`bson.D`&`bson.A`

另外一个在看doc的时候很迷惑的地方是这个。官方文档 上写的是：

```go
bson.D{
    {"status", "A"},
    {"$or", bson.A{
        bson.D{{"qty", bson.D{{"$lt", 30}}}},
        bson.D{{"item", primitive.Regex{Pattern: "^p", Options: ""}}},
    }},
}
```

bson.D是把每一个括号`{}`都当成一个array里面的element。每一个element是key-value的形式。



```go
bson.M{
    "username":   u.Username,
    "password":   u.Password,
    "createDate": u.CreatedDate,
}
```

在bson.M里，这个是个map对象，里面的顺序是不做保证的。M is an unordered representation of a BSON document. 



```go
bson.A{"bar", "world", 3.14159, bson.D{{"qux", 12345}}}
```

在bson.A里，是普通数组，每一个element不是kv形式。



详细的参考手册：

[1] docker offical doc: https://docs.docker.com/compose/compose-file/compose-file-v3/

[2] 挺好的中文教程，只不过有些地方还是不够详细，但是是很棒的前情提要：https://yeasy.gitbook.io/docker_practice/

[3] bson doc: https://pkg.go.dev/go.mongodb.org/mongo-driver/bson#A

