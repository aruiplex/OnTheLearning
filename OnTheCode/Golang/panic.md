`Go`中可以抛出一个`panic`的异常（超级大异常），然后在`defer`中通过`recover`捕获这个异常，然后正常处理。普通错误通过`err`返回。

一般就HTTP服务的全局做一个`recover`,然后任何地方`panic`都能全局捕获相应一个错误。

可以说是err是局部异常处理，panic(err)是全局的异常处理了，因为panic会打破常规的程序顺序。





reference

[1] 经典 https://draveness.me/golang/docs/part2-foundation/ch05-keyword/golang-panic-recover/

