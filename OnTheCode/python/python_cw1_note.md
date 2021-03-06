# aruixsync

config file specific:

```json
{
  //   listen on host and port
  "server": {
    "host": "127.0.0.1",
    "port": 20001
  },
  //   file to persist sync information
  "db_file": "db.json",
  //   scan file interval (s)
  "sync_interval": 2,
  //   recv buffer size (B)
  "buffer_size": 1024,
  //   compress level 0-9, higher is smaller
  "compress_level": 6,
  //   is encryption?
  "encryption": false,
  //   the peers' ip
  "ips": [],
  //   file block size to divide file (B), default is 1M
  "file_block_size": 1048576,
  //   the share directory
  "sync_dir": "./share"
}
```

json 里面是没有 set 的

dict 可以直接使用 dict 的引用来修改其中的值的. (因为 dict 是复杂的数据结构, 所以放在堆里面, 所以每一次都是按地址引用, 所以可以直接修改其中的值)

```python
db["a"] = [1,2,3,4]
# db的 "a" 属性就改变了
```

```python
# 另一种写 pack 的方法
header_length.to_bytes(4, "big") + self.body_length.to_bytes(4, "big") + self.header + self.body
```

```python
def __unwrap(self, store):
    """已弃用
    unwrap the package from store
    """
    self.header_length, self.body_length = struct.unpack(
        "!II", store[:8])
    self.header = store[8:8 + self.header_length]
    self.header = eval(self.header.decode())
    self.body = store[8 + self.header_length:8 +
                      self.header_length + self.body_length]
    store = store[8 + self.header_length + self.body_length:]
    # if FIN is true, the finish
    FIN = self.body_length == 0 and self.header_length == 0
    return self, store, FIN

```

```python
# 从 str 转到 dict 和 set
s = {s,e,t}
# eval的作用就是让 str 回归它原本的作用
eval(s)

ss = {s,e,t,a}
# union 与 update 的区别
sss = s.union(ss)

s.update(ss)

```

`set()`里面不能存放 dict

list 可以相互加起来

```python
l = [1, 2, 3, 4, 5]

ll = [5, 6, 7, 8, 9]

print(l+ll)

# set add list
s = set{1,2,3,4}

s.update(l)
```

list append dict

python 变量通过参数传递的时候, 传递的是指针, 会对原来的值做出修改
