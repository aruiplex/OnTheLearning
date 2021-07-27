连接：

```bash
sftp -oPort=custom_port sammy@your_server_ip_or_remote_hostname
```



使用方法:

```bash
# remote current directory
sftp> pwd
# local current directory
sftp> lpwd
```

命令前面加`l`就是`local`的命令了.

`get` 命令用于下载:

```bash
# Transferring Remote Files to the Local System
sftp> get remoteFile
# change file name from remote to local
sftp> get remoteFileName localFileName
# get Directory
sftp> get -r someDirectory
# get directory with permisson
sftp> get -Pr someDirectory
```

`put`命令用于上传

```bash
# Transferring Local Files to the Remote System
sftp> put remoteFile
# change file name from remote to local
sftp> put remoteFileName localFileName
# get Directory
sftp> put -r someDirectory
# get directory with permisson
sftp> put -Pr someDirectory
```













[1] https://www.digitalocean.com/community/tutorials/how-to-use-sftp-to-securely-transfer-files-with-a-remote-server

