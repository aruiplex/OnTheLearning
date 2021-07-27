# Exception

大概分成两类:



#### Checked Exception

---

作用: 用来传递特殊值. signal special results

标识: 需要在函数头做标识

继承: `Exception`

> 这个 *checked* 的意思我的理解是: 
>
> 需要程序员自己check



#### Unchecked Exception

---

作用: 传递bugs, signal bugs.

标识: 不要在函数头做标识

继承: `RuntimeException`

Errors should be considered unrecoverable, and should notbe caught by your code

> 不用程序员自己check, 程序负责check



![image-20210412182927632](image/image-20210412182927632.png)