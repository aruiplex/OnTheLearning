# Golang



## Module

Go的module和package的方式和别的语言都不一样。

module是一个大项目的名字，package是每一个分区的名字。



在import的时候，要`module/package`这样的格式进行导入。



举个例子：`module`是`aruix.net/my-fyp`，`package`是`algo`，那就把他们连在一起就好了。





## grpc

go的plugin是在bin下面的，类似于python的pip这样的小工具。

```bash
go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.26
go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.1
```

这样就装在go环境的下面了。但是还是需要把bin文件夹放在path里才能用：

```sh
export PATH="$PATH:$(go env GOPATH)/bin"
```

真的太麻烦了。





生成代码：

```sh
protoc --go_out=. --go_opt=paths=source_relative \
    --go-grpc_out=. --go-grpc_opt=paths=source_relative \
    helloworld/helloworld.proto
```

protoc cli也是难用的一批。`--go-grpc_out`才是会使用grpc相关的plugin，才会生成grpc相关的代码。path的作用是生成的代码就放在这个文件夹下（意思这个已经是相对路径了），不然又会在建立没有必要的文件夹。