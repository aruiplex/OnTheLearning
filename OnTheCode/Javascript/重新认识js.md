我原来一直不明白, 这里的`length`为什么没有括号. 

这一次终于解决了我的疑问, 

这里的`length`就是`String`的一个属性, 而不是`getLength()`这样的函数. 


```js
"hello".length; // 5
```





两种`for`, 一种是对属性遍历, 一种是对值进行遍历.

```js
// JavaScript 也还包括其他两种重要的 for 循环： for...of

for (let value of array) {
  // do something with value
}

// 和 for...in ：

for (let property in object) {
  // do something with object property
}
```



函数传入的参数实际上是`argument`