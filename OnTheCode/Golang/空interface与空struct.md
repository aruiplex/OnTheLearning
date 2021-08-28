# interface{} & struct{} Memory allocate



A variable of type `interface{}` can hold any value. E.g. it can hold the integer `8`, it can hold the `string` value `"hi"`, it can hold the struct value `image.Point{X: 1, Y: 2}` and pretty much everything else.

空interface可以装下任何值, 比如数字8, 或者是字符串"hi", 或者是一个 stuct{} .

If you allocate a slice having `interface{}` as its element type, memory have to be allocated so that you can store any values in its elements. When using `make()` to allocate it, all its elements will get the zero value of the element type (which is `nil` for the `interface{}`), but memory still has to be allocated else you couldn't set elements later on.

如果你给一个切片分配的类型为 空interface, 内存就会被分配, 你才能在interface里存任何东西. 用 `make()` 来分配内存的时候, 所有的 interface{} 都会被赋值为 "0", 对空interface{}来讲就是 nil . 但是内存还是必须给 interface{} 的, 不然之后就不能把东西放进去了. 

On the other hand, the empty struct `struct{}` has no fields, it cannot hold any values (other than `struct{}`). When you allocate a slice having `struct{}` as its element type, memory does not need to be allocated because you won't be able to store anything in it that would require memory. So it's a simple and clever optimization not to allocate memory for such a type.

从另一方面讲, 空结构没有字段, 它不能拥有任何值, 就不用占用内存.



概括一下, interface{} 因为可以往里面放东西, 所以必须有内存空间, 但是 struct{} 里面再也放不了东西了, 所以不用占用空间.

