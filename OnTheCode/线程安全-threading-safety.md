# 线程安全

### 什么是线程安全

This means that different threads can access the same resources without exposing erroneous behavior or producing unpredictable results. This programming methodology is known as “thread-safety” [1].

多个线程可以获取相同的资源, 而不会暴露错误行为或者得到不可预测的结果, 这就叫做线程安全.

Thread-safe code is code that will work even if many Threads are executing it simultaneously. Writing it is a black art. It is extremely difficult to debug since you can’t reproduce all possible interactions between Threads. You have to do it by logic. In a computer, something that happens only one in a billion times must be dealt with because on average it will happen once a second. To write code that will run stably for weeks takes extreme paranoia.

多线程很难debug, 只能通过逻辑来思考, 脑内编译 & debug.





reference:

[1] https://www.baeldung.com/java-thread-safety