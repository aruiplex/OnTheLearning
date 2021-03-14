# for range

题目是 for range , 但其实我想写的是指针的问题.



```go
x := make([]int, 3)

x[0], x[1], x[2] = 1, 2, 3

for i, val := range x {
    println(&x[i], "vs.", &val)
}

//output:
----------------------------------
0xf84000f010 vs. 0x7f095ed0bf68
0xf84000f014 vs. 0x7f095ed0bf68
0xf84000f018 vs. 0x7f095ed0bf68
```



for range 遍历出来的东西并不能是指针, 而是一个值.

一个值代表的是, 他是一个独立的变量, 而指针意味着: 这就是这个变量.

