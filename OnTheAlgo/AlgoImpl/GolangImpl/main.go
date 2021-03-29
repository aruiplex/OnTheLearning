package main

import (
	"fmt"
)

func main() {
	t := 0
	fmt.Scan(&t)
	arr := []int{}
	el := 0
	for i := 0; i < t; i++ {
		fmt.Scan(&el)
		arr = append(arr, el)
	}
	fmt.Println(arr)
}
