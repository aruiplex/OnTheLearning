好像所有的老牌网络请求相关的工具都有这个debug选项

1. curl
2. wget
3. ssh

这些都有,



**tl;dr**: there is no difference between `-v` and `-vvv`.

> Specifying -v multiple times usually means to increase verbosity accordingly.

This is true, e.g for a software like [memcached](http://memcached.org/):

```
-v            verbose (print errors/warnings while in event loop)
-vv           very verbose (also print client commands/reponses)
-vvv          extremely verbose (also print internal state transitions)
```

(behind the scenes the options parser [accumulates the level of verbosity](https://github.com/memcached/memcached/blob/e73bc2e/memcached.c#L5155-L5157)).

But with curl command-line tool this is not the case. As you can see from [tool_getparam.c](https://github.com/bagder/curl/blob/a7999da/src/tool_getparam.c#L1688-L1699), passing `-v` simply *toggles* the so-called trace type to `TRACE_PLAIN`. Passing `-vv` or `-vvv` does the same.