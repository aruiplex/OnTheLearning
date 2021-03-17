package main

import (
	"fmt"
	"unsafe"
)

func main() {
	a := make([]interface{}, 11)
	var i interface{}
	fmt.Println(unsafe.Sizeof(a))
	fmt.Println(unsafe.Sizeof(i))
	fmt.Println(&a)
	fmt.Println(&i)
	fmt.Println(i)
}
