# Python Statistic

`numpy.histogram()`是`python`的直方统计, `matplotlb.pyplot` 库中的用法与`numpy`中的是一致的.

```python
numpy.histogram(a, bins=10, range=None, normed=None, weights=None, density=None)

bins: 		有bins那么多个桶(多条)
density:	如果是False, 那么是根据sample的个数画出来的直方图. 如果是True, 那么则是这个函数的PDF(probability density function)在这个桶的值. 一个是个数, 一个是值.
    
```

