# loc

`pandas`的`.loc()`给`dataframe`提供了一种data slice的方式，可以让`dataframe`像`numpy`一样切。

```python
df_raw = pd.read_csv(_file).loc[:, "WAP001":"BUILDINGID"]
```

相当于`numpy`直接用`[]`索引