Go 很吸引人的一点就是可以编译出来不需要，运行时。

Python需要，Java更需要，并且打包出来之后太大了。

在Linux上写好之后，想build成Windows上运行的。改变一下环境变量就好了。

```bash
GOOS=windows GOARCH=amd64 go build
```



##### Reference

[1] https://stackoverflow.com/questions/41566495/golang-how-to-cross-compile-on-linux-for-windows/41572593

