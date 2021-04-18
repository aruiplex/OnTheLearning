package impl

import "fmt"

/*
用于acm形式下的提交时 input/output
*/
func examIO() {
	t := 0
	fmt.Scan(&t)
	arr := []int{}
	el := 0
	for i := 0; i < t; i++ {
		fmt.Scan(&el)
		arr = append(arr, el)
	}
	fmt.Println()
}
