## 复制一个`dataframe`，但是只需要特定的`column`

```python
df = pd.read_csv("/home/aruix/aruixDAO/Code/gaussian_process/data/campus_clean.csv").filter(
    ["LONGITUDE", "LATITUDE", "BUILDINGID", "FLOOR"]).copy()
print(df.groupby(["BUILDINGID", "FLOOR"]).max())
print(df.groupby(["BUILDINGID", "FLOOR"]).min())
```

用[`.filter()`](https://pandas.pydata.org/docs/reference/api/pandas.DataFrame.filter.html)，就可以做到用列名获得这一列。

pandas的内置函数太多了实在不好记。我思考了一下，感觉也是没办法，毕竟处理表格的操作步骤也是挺多的。