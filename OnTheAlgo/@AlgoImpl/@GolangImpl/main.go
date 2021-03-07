package main

import (
	"fmt"

	"aruix.net/code/algo/impl"
)

func main() {
	// a := []int{7, 7}
	// k := 4
	// fmt.Println(int(math.Ceil(float64(a[0]) / float64(k))))
	// piles := []int{3, 6, 7, 11}
	// H := 8
	// fmt.Println(impl.MinEatingSpeed(piles, H))

	// piles = []int{30, 11, 23, 4, 20}
	// H = 5
	// fmt.Println(impl.MinEatingSpeed(piles, H))

	piles := []int{3, 6, 7, 11}
	H := 8
	fmt.Println(impl.MinEatingSpeed(piles, H))
}
