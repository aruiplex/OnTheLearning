# File operation in Python

对文件夹与文件进行操作:

```python
import os

a = os.walk(".\\")
for i in a:
    path, dir_name_list, file_name_list = i
    for file_name in file_name_list:
        # remove the file which file name contains "sync-conflict"
        if "sync-conflict" in file_name:
            p = path + "\\"+file_name
            os.remove(p)
            # print(p)
```

解放了双手, 重复的工作都可以交给 code 去解决.

```python
a = os.walk("d:\\SendSync\\")
for i in a:
    path, dir_name_list, file_name_list = i
    for file_name in file_name_list:
        # remove the file which file name contains "(1)"
        if "(1)" in file_name:
            p = path + "\\"+file_name
            os.remove(p)
            # print(p)

```

列出当前文件夹下的所有项，不管是文件夹还是文件。

```python
os.listdir()

# output
['All Users', 'aruix', 'Default', 'Default User', 'desktop.ini', 'Public']
```





