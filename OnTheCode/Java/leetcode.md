# leetcode note

## java 中的 null

java 里的空对象都是 null

如何判断对象是否为空对象?

1. obj == null

这里为啥不用 `.equals` ? 反正就是 `==`

> 请解释字符串比较之中“==”和 equals()的区别？
>
> `==`: 比较的是两个字符串内存地址（堆内存）的数值是否相等，属于数值比较
>
> `equals()`：比较的是两个字符串的内容，属于内容比较。
>
> equals 通常用来比较两个对象的内容是否相等，==用来比较两个对象的地址是否相等。

## 堆栈

堆: 存放 new 出来的对象

静态域：存放静态成员（static 定义的）

常量池：存放字符串常量和基本类型常量（public static final）。有时，在嵌入式系统中，常量本身会和其他部分分割离开(由于版权等其他原因)，所以在这种情况下，可以选择将其放在 ROM 中 。

## java 赋值

我 giao!

java 中对象名是引用, 不是重新复制了一份出来;

比如:

```java
    Student st1 = new Student(1, "zcrbb");
    Student st2 = st1;
    st2.setId(2);
    st2.setName("Aruix");
    System.out.println(st1 + "\n" + st2);
```

st1 和 st2 是指向同一个对象的指针
