import os

s = "aa"

a = os.walk(".\\")
for i in a:
    path, dir_name_list, file_name_list = i
    for file_name in file_name_list:
        if "sync-conflict" in file_name:
            p = path + "\\"+file_name
            os.remove(p)
            # print(p)
