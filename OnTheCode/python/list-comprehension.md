# List Comprehension

是python的简便用法，类似于lambda表达式

```python
l = [x.operation() in x for a_list]
```

可以从一个list直接生成另一个list。



这个东西不仅能生成list，还能生成dict。

syntax:

```python
d = {key: value for (key, value) in iterable}
```



example:

```python
# movies is a list of dict
d = {x["name_zh"]: x for x in movies}
```

