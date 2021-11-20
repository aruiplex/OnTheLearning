# Shell configure

有这么几个地方：

| File               | Funciton |      |
| ------------------ | -------- | ---- |
| `/etc/profile`     |          |      |
| `/etc/bashrc`      |          |      |
| `/etc/environment` |          |      |
| `~/.bashrc`        |          |      |
| `~/.profile`       |          |      |
| `~/.zshrc`         |          |      |



在etc文件夹下的都是系统层面的配置文件，在~下面的是用户层面的。

介绍zsh的几个配置文件（`.zlogin`, `.zprofile`, `.zshrc`, `.zlogout`, `.zshenv`）的区别的[文章](https://unix.stackexchange.com/questions/71253/what-should-shouldnt-go-in-zshenv-zshrc-zlogin-zprofile-zlogout)。

介绍`.profile`与`.zprofile`的[文章](https://superuser.com/questions/187639/zsh-not-hitting-profile)



因为bashScript与zshScript的语法不同，所以不能混用。但是我有一些用bash写的配置，再让我不断的同步他们两个很不合适。我现在的做法是，在`.zshrc`的文件里添加下面的代码，把``bashScript`转化`zshScript`。具体是把用户目录里的`profile`与全局的`profile`都激活。

```zsh
[[ -e ~/.profile ]] && emulate sh -c 'source ~/.profile && source /etc/profile'
```

