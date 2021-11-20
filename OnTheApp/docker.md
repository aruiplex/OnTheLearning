# Docker

有三个基础概念：

1. 镜像`image`
2. 容器`container`
3. 仓库`repository`



## 镜像

操作系统分成 内核 和 用户空间。对于 `Linux` 而言，内核启动后，会挂载 `root` 文件系统为其提供用户空间支持。而 **Docker 镜像**（`Image`），就相当于是一个 `root` 文件系统。比如官方镜像 `ubuntu:18.04` 就包含了完整的一套 Ubuntu 18.04 最小系统的 `root` 文件系统。

**Docker 镜像** 是一个特殊的文件系统，除了提供容器运行时所需的程序、库、资源、配置等文件外，还包含了一些为运行时准备的一些配置参数（如匿名卷、环境变量、用户等）。镜像 **不包含** 任何动态数据，其内容在构建之后也不会被改变。

镜像并非是像一个 `ISO` 那样的打包文件，镜像只是一个虚拟的概念，其实际体现并非由一个文件组成，而是由一组文件系统组成，或者说，由多层文件系统联合组成。

镜像构建时，会一层层构建，前一层是后一层的基础。每一层构建完就不会再发生改变，后一层上的任何改变只发生在自己这一层。比如，删除前一层文件的操作，实际不是真的删除前一层的文件，而是仅在当前层标记为该文件已删除。在最终容器运行的时候，虽然不会看到这个文件，但是实际上该文件会一直跟随镜像。

分层存储的特征还使得镜像的复用、定制变的更为容易。甚至可以用之前构建好的镜像作为基础层，然后进一步添加新的层，以定制自己所需的内容，构建新的镜像。

## 容器

镜像（`Image`）和容器（`Container`）的关系，就像是面向对象程序设计中的 `类` 和 `实例` 一样，镜像是静态的定义，容器是镜像运行时的实体。容器可以被创建、启动、停止、删除、暂停等。

容器的实质是进程，但与直接在宿主执行的进程不同，容器进程运行于属于自己的独立的 [命名空间](https://en.wikipedia.org/wiki/Linux_namespaces)。因此容器可以拥有自己的 `root` 文件系统、自己的网络配置、自己的进程空间，甚至自己的用户 ID 空间。容器内的进程是运行在一个隔离的环境里，使用起来，就好像是在一个独立于宿主的系统下操作一样。这种特性使得容器封装的应用比直接在宿主运行更加安全。也因为这种隔离的特性，很多人初学 Docker 时常常会混淆容器和虚拟机。

前面讲过镜像使用的是分层存储，容器也是如此。每一个容器运行时，是以镜像为基础层，在其上创建一个当前容器的存储层，我们可以称这个为容器运行时读写而准备的存储层为 **容器存储层**。

容器存储层的生存周期和容器一样，容器消亡时，容器存储层也随之消亡。因此，任何保存于容器存储层的信息都会随容器删除而丢失。

按照 Docker 最佳实践的要求，容器不应该向其存储层内写入任何数据，容器存储层要保持无状态化。所有的文件写入操作，都应该使用 [数据卷（Volume）]()、或者 [绑定宿主目录]()，在这些位置的读写会跳过容器存储层，直接对宿主（或网络存储）发生读写，其性能和稳定性更高。

数据卷的生存周期独立于容器，容器消亡，数据卷不会消亡。因此，使用数据卷后，容器删除或者重新运行之后，数据却不会丢失。



## Dockerfile

Dockerfile 是一个文本文件，其内包含了一条条的 **指令(Instruction)**，每一条指令构建一层，因此每一条指令的内容，就是描述该层应当如何构建。







我是有点懵的，对于如何持续化docker container的所有改变，以至于能让我用来存储东西。







挂在点 之外的目录是不会存在volume里面的。当前的container stop之后，存储层的文件还不会消失，当container被删了之后，存储层就会消失。



## Docker with vscode 

在vscode中使用docker进行开发。

在`.devcontainer/devcontainer.json`中的配置是：

```json
// For format details, see https://aka.ms/devcontainer.json. For config options, see the README at:
// https://github.com/microsoft/vscode-dev-containers/tree/v0.205.2/containers/python-3
{
	"name": "Python 3",
	"build": {
		"dockerfile": "Dockerfile",
		"context": "..",
		"args": { 
			// Update 'VARIANT' to pick a Python version: 3, 3.10, 3.9, 3.8, 3.7, 3.6
			// Append -bullseye or -buster to pin to an OS version.
			// Use -bullseye variants on local on arm64/Apple Silicon.
			"VARIANT": "3.10-bullseye",
			// Options
			"NODE_VERSION": "lts/*"
		}
	},

	// Set *default* container specific settings.json values on container create.
	"settings": { 
		"python.defaultInterpreterPath": "/usr/local/bin/python",
		"python.linting.enabled": true,
		"python.linting.pylintEnabled": true,
		"python.formatting.autopep8Path": "/usr/local/py-utils/bin/autopep8",
		"python.formatting.blackPath": "/usr/local/py-utils/bin/black",
		"python.formatting.yapfPath": "/usr/local/py-utils/bin/yapf",
		"python.linting.banditPath": "/usr/local/py-utils/bin/bandit",
		"python.linting.flake8Path": "/usr/local/py-utils/bin/flake8",
		"python.linting.mypyPath": "/usr/local/py-utils/bin/mypy",
		"python.linting.pycodestylePath": "/usr/local/py-utils/bin/pycodestyle",
		"python.linting.pydocstylePath": "/usr/local/py-utils/bin/pydocstyle",
		"python.linting.pylintPath": "/usr/local/py-utils/bin/pylint"
	},

	// Add the IDs of extensions you want installed when the container is created.
	"extensions": [
		"ms-python.python",
		"ms-python.vscode-pylance",
		"yzhang.markdown-all-in-one"
	],

	// Use 'forwardPorts' to make a list of ports inside the container available locally.
	// "forwardPorts": [],

	// Use 'postCreateCommand' to run commands after the container is created.
	"postCreateCommand": "pip3 install --user -r requirements.txt",

	// Comment out connect as root instead. More info: https://aka.ms/vscode-remote/containers/non-root.
	// "remoteUser": "root"
}

```

这个json file是为了给docker在vscode中提供帮助。比如提供一些插件extensions，vscode在docker中的settings

