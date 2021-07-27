# IO多路复用机制

epoll, poll, select

这三个都是IO多路复用的机制.

> 多路复用: 监视多个文件描述符(file descriptor)的读写事件, 一旦某个fd就绪(某个文件发生了读写事件, 这里我觉得应该是fd被process add 进了 list), 系统就能将发生的事件通知给应用程序去处理.
>
> 主要在于**多个**, 是**多**路复用所强调的

下面简单的说一下这三个的特点:

1. select

    要不断遍历, 才能知道是哪个fd发生了IO操作. 并且每次操作要把 fd_set 从内核太拷贝到用户态, 不断copy就很费时间.

2. poll

    与select相比没有本质区别, 只是没有fd个数限制.

3. epoll

    event poll, 由事件驱动, 就避免了不断遍历, 只考虑活跃的连接. 是用mmap就不需要在内存里反复copy了





reference:

1. epoll: https://www.cnblogs.com/aspirant/p/9166944.html
2. 描述符就绪条件: https://blog.csdn.net/kyang_823/article/details/79496303