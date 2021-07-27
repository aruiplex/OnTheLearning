# Permission of linux

use command `ls -l` to check the permission of file or dir.

```bash
aruix@alinux:~/.ssh$ ls -l
total 12
-rw------- 1 aruix aruix 3434 4月   5  2020 id_rsa
-rw------- 1 aruix aruix  743 2月   9 22:31 id_rsa.pub
-rw-r--r-- 1 aruix aruix 1332 5月   1 23:38 known_hosts
```

![img](image/file-llls22.jpg)

The first char represent:

- 当为 **d** 则是目录
- 当为 **-** 则是文件；
- 若是 **l** 则表示为链接文档(link file)；
- 若是 **b** 则表示为装置文件里面的可供储存的接口设备(可随机存取装置)；
- 若是 **c** 则表示为装置文件里面的串行端口设备，例如键盘、鼠标(一次性读取装置)。













### chmod

change mode of file.

| command | owner | operation | permission | destination |
| :-----: | :---: | :-------: | :--------: | :---------: |
|  chmod  |   u   |  +: add   |     r      |    file     |
|         |   g   | -: minus  |     w      |  directory  |
|         |   o   |  =: set   |     x      |             |
|         |   a   |           |            |             |



For directory, `-R` is recursive option.



### chown

change owner ship.

```bash
chown [–R] <owner name> <file name>
chown [-R] <owner name>：<owner group name> <file name>
```

Which means `chgrp` is not useful.



### chgrp

change group of file.

```bash
chgrp [-R] <group name> <file name>
```



