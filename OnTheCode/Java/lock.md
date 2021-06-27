# Lock

```java
public class ThreadBoundedQueue implements Runnable {
    private BoundedQueue q;
    private static int count = 0;
    static Object lock = new Object();

    ThreadBoundedQueue(BoundedQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        // 锁for里面外面都可以
        synchronized (lock) {
            for (int i = 0; i < 20; i++) {
                if (q.isEmpty()) {
                    q.add(count++);
                } else {
                    try {
                        System.out.println(q.get());
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BoundedQueue q = new BoundedQueue();
        Thread t1 = new Thread(new ThreadBoundedQueue(q));
        Thread t2 = new Thread(new ThreadBoundedQueue(q));
        Thread t3 = new Thread(new ThreadBoundedQueue(q));
        t1.start();
        t2.start();
        t3.start();
    }
}
```

Some requirements:

1. Must use the **same** lock object to lock several threads. If use different objects, it can not lock them. That why Java use object to lock threadings.
2. To @Overload method, the name must as same.
3. Use *synchronized* keyword in the method signature is as same as  `synchronized (this) {...}`, use this instance object to lock method.

4. Use passed arguments or instance variables to ensure the lock is same, for example the instance variable `lock` and the passed argument `q`.

