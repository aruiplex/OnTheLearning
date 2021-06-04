# Linux bash 控制符号

### > 重定向

`>>`代表*append*, `>`代表覆盖, `<`标准输入

`&>`是 `2>&1` 的缩写, 代表着把 *stderr* 也放到 *stdout* 中, 与`&后台`没什么关系, 有点取地址的感觉.

经常会重定向到 *dev/null* 中,  就是代表着不要了.



### & 后台任务

会把任务放在后台完成, 但是还是会有*stdout*.

> stdout还是会输出到屏幕



#### <在同一终端中> 前后台之间的切换:

1. `jobs`: 当前终端正在运行的进程.
2. `fg`: 把后台任务放到前台.
3. `bg`: 把前台任务放到后台.



### | 管道

上一条命令的输出是下一条命令的输入



shortcut:

1. `command1 |& command2` 

    等于`2>&1 |`把标准输入输出都传递给下一个命令.



reference:

[1] https://unix.stackexchange.com/questions/159513/what-are-the-shells-control-and-redirection-operators

[2] https://askubuntu.com/questions/338857/automatically-enter-input-in-command-line

[3] good answer about redirect sign in linux: https://askubuntu.com/questions/420981/how-do-i-save-terminal-output-to-a-file