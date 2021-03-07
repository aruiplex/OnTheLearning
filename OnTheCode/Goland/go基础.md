### 可见性

Go的导入与别的语言都不一样,

是通过第一个字母的大小写来判定的.

```go
// public, 
SayHello()

// private, 对包外是不可见的. 
sayHello()
```

所有的标识符都遵从这个原则: 变量, 结构体, 函数, 类型...



go的 main 函数必须在main package下面.



### 变量

```go

// 声明变量 变量名 类
var haha int 
// 声明变量 + 变量赋值
var haha int = 666



// 变量声明 + 变量赋值
haha := "haha"
```

go是有全局变量的说法的

```go
// 这种因式分解关键字的写法一般用于声明全局变量
var (
    vname1 v_type1
    vname2 v_type2
)
```



### 常量

```go
// 常量还可以用作枚举：

const (
    Unknown = 0
    Female = 1
    Male = 2
)


```

特殊常量 `iota ` 没看懂

### 运算符

```go

```

看到了一个在别的语言中没见过的 "位运算". 并且golang是有复数的(complex number), 这就很有意思了.

先说位运算:

```go
b := 3
for v := 0; v < 10; v++ {
	b <<= v
	fmt.Printf("v: %d, b: %d \n", v, b)
}

// 输出

v: 0, b: 3 
v: 1, b: 6       
v: 2, b: 24      
v: 3, b: 192     
v: 4, b: 3072    
v: 5, b: 98304   
v: 6, b: 6291456 
v: 7, b: 805306368
v: 8, b: 206158430208
v: 9, b: 105553116266496

// --------------------

b := 2048
for v := 0; v < 10; v++ {
	b >>= v
	fmt.Printf("v: %d, b: %d \n", v, b)
}

v: 0, b: 2048 
v: 1, b: 1024
v: 2, b: 256
v: 3, b: 32
v: 4, b: 2
v: 5, b: 0
v: 6, b: 0
v: 7, b: 0
v: 8, b: 0
v: 9, b: 0
```

可以看出来这样的位运算(<<=)就是 :
$$
outout = input \times 2^{v}
$$
这样的位运算(>>=)就是:
$$
output = input / 2^{v}
$$




### 循环

go有3种循环, 但是都是基于 `for` 的.

```go
尊享版
for init; condition; post { 
/ init： 一般为赋值表达式，给控制变量赋初值；
/ condition： 关系表达式或逻辑表达式，循环控制条件；
/ post： 一般为赋值表达式，给控制变量增量或减量。
}

while
for condition {
    
}

无限循环
for {
    
}

加强版 foreach
for 循环的 range 格式可以对 slice、map、数组、字符串等进行迭代循环。格式如下：
能遍历key还是挺动态语言的

for key, value := range oldMap {
    newMap[key] = value
}
```

还有一些通用的语句:

| 语句                                                         | 作用                                             |
| ------------------------------------------------------------ | ------------------------------------------------ |
| [break 语句](https://www.runoob.com/go/go-break-statement.html) | 经常用于中断当前 for 循环或跳出 switch 语句      |
| [continue 语句](https://www.runoob.com/go/go-continue-statement.html) | 跳过当前循环的剩余语句，然后继续进行下一轮循环。 |
| [goto 语句](https://www.runoob.com/go/go-goto-statement.html) | 将控制转移到被标记的语句。                       |

所以说go的语句设计的还是很有道理的, 没有java那么繁琐, 没有cpp那么让我觉得自己是傻逼,

没有python的混乱.



### 变量类型

- (a) 指针类型（Pointer）

    这里的指针和cpp的指针是一样的 (本来所有指针也都一样)

    指针不仅是保存了一个地址, 它还可以本用来直接找到这个变量.

    

    意思是:

    `&variable` 能得到一个地址, 但是这个地址也就是一个地址而已

    但是一个指针 `pointer ptr := &variable` 就是一个能起作用的地址, 能根据这个地址发挥出指针的作用, 重点体现在**指**.

    

    指针算是有3个用法:

    1. 定义指针变量。
    2. 为指针变量赋值。
    3. 访问指针变量中指向地址的值。

    ```go
    var a int= 20   /* 声明实际变量 */
    var ip *int        /* 声明指针变量 */
    
    ip = &a  /* 指针变量的存储地址 */
    
    fmt.Printf("a 变量的地址是: %x\n", &a  )
    
       /* 指针变量的存储地址 */
    fmt.Printf("ip 变量储存的指针地址: %x\n", ip )
    
       /* 使用指针访问值 */
    fmt.Printf("*ip 变量的值: %d\n", *ip )
    
    ```

    



- (b) 数组类型

    ```go
    声明:
    var variable_name [SIZE] variable_type
    var array1 [10] int
    
    声明 + 赋值:
    var array1 = [10] int {1,2,3,4,5,6,7,8}
    array2 := [10] int {1,2,3,4,5,6,7}
    
    数组的长度不一定:
    var balance = [...]float32{1000.0, 2.0, 3.4, 7.0, 50.0}
    或
    balance := [...]float32{1000.0, 2.0, 3.4, 7.0, 50.0}
    
    根据索引赋值: (这东西java和python都是没有的)
    将索引为 1 和 3 的元素初始化
    balance := [5]float32{1:2.0,3:7.0}
    
    还有喜闻乐见的多维数组：
    array2 := [][]int{} 
    row1 := [5]int{1,2,3,4,5}
    row2 := [5]int{1,2,3,4,5}
    
    别的 用到的时候再说吧，本来也就记不住
    ```

    数组是连续的内存, 所以数组大小是必填的也是很正常.

- (c) 结构化类型(struct)

    ```go
    定义
    type struct_variable_type struct {
       member definition
       member definition
       ...
       member definition
    }
    
    赋值
    variable_name := structure_variable_type {value1, value2...valuen}
    或
    variable_name := structure_variable_type { key1: value1, key2: value2..., keyn: valuen}
    
    
    ```

    这样的结构体赋值看起来挺方便的

    但是和我原来接触过的语言还是有很大差别的.

    就比如最基础的构造函数, struct是没有的.

    只能通过这样的方式来 在精神上new一个

    ```go
    student1 := Student{}
    当然也有new关键字, 但是是全部赋予0值
    student2 := new(Student)
    
    ```

    



- (d) Channel 类型
- (e) 函数类型
- (f) 切片类型
- (g) 接口类型（interface）
- (h) Map 类型



### 函数

```go
func function_name( [parameter list] ) [return_types] {
   函数体
}
```

接下来就是我在用`cpp`的时候, 觉得`cpp`比`java`和`python`做的都要好的地方了, 当然现在go也做到了:



**按值传递 & 引用传递**

| 传递类型                                                     | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [值传递](https://www.runoob.com/go/go-function-call-by-value.html) | 值传递是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。 |
| [引用传递](https://www.runoob.com/go/go-function-call-by-reference.html) | 引用传递是指在调用函数时将实际参数的地址传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。 |

*默认情况下*，Go 语言使用的是值传递，即在调用过程中不会影响到实际参数。也就是说会把内存再复制一份. java python也都是这个样.



这东西应该还是很有用的, 很灵活, 像cpp一样, 可以直接把变量的值改了, 而不是在把值赋给他.

```go
/* 定义交换值函数*/
func swap(x *int, y *int) {
   var temp int
   temp = *x    /* 保持 x 地址上的值 */
   *x = *y      /* 将 y 值赋给 x */
   *y = temp    /* 将 temp 值赋给 y */
}

在调用的时候:
a := 1
b := 2
swap(&a, &b)

```

引用传递在函数上写的是`*`, 调用时候写的是 `&`



对于面向对象来讲, 因为Go不是标准形式的`class`, `class`是`java`和`python`标准的`oop`. 他是用结构`stuct`来替代的`class`, 所以一个`stuct`他自己的**方法**并没有办法写在`stuct`里面, 对象的函数都是被称作为**方法**, Go是通过在函数上写标志来做到把函数指派给`stuct` 

> 对象的函数都是被称作为**方法**

```go
这是一个普通的函数体的形式: 
func function_name() [return_type]{
   /* 函数体*/
}

这是一个方法的形式:
func (variable_name variable_data_type) function_name() [return_type]{
   /* 函数体*/
}


/* 定义结构体 */
type Circle struct {
  radius float64
}

func main() {
  var c1 Circle
  c1.radius = 10.00
  fmt.Println("圆的面积 = ", c1.getArea())
}

//该 method 属于 Circle 类型对象中的方法
func (c Circle) getArea() float64 {
  //c.radius 即为 Circle 类型对象中的属性
  return 3.14 * c.radius * c.radius
}

注意这里要传指针:
func (c *Circle) changeRadius(radius float64) float64{
    c.radius = radius
}

要是前面不表明这是一种方法的话, 这里就要把指针当作参数传进去了
func change(c *Circle, radius float64)  {
   c.radius = radius
}
```

~~我终于看明白了, 菜鸟教程真的好懂, 新手入门一定不要先看官方教程.... 原来我学rust的时候, 这点卡了我好长时间的~~





