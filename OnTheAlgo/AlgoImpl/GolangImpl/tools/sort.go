package tools

import (
	"container/heap"
	"fmt"
)

// QuickSort is an implemention of quick sort
func QuickSort(array []int) []int {
	ans := []int{}
	less := []int{}
	greater := []int{}
	if len(array) <= 1 {
		return array
	}
	pivot := array[0]
	for i := 1; i < len(array); i++ {
		v := array[i]
		if v <= pivot {
			less = append(less, v)
		} else {
			greater = append(greater, v)
		}
	}
	less = QuickSort(less)
	greater = QuickSort(greater)
	ans = append(ans, less...)
	ans = append(ans, pivot)
	ans = append(ans, greater...)
	return ans
}

func BucketSort(arr []int) {
	bucket := make([]IntArr, 10)

	max := arr[0]
	for _, elem := range arr {
		if elem > max {
			max = elem
		}
	}

	min := arr[0]
	for _, elem := range arr {
		if elem < min {
			min = elem
		}
	}

	width := (max-min)/10 + 1

	for _, elem := range arr {
		x := (elem - min) / width
		heap.Push(&bucket[x], elem)
	}

	for i := 0; i < 10; i++ {
		heap.Init(&bucket[i])
	}

	index := 0
	for i := 0; i < 10; i++ {
		fmt.Println("Bucket", i, ":", bucket[i], "=== length", len(bucket[i]))
		for j := 0; j < len(bucket[i]); j++ {
			arr[index] = heap.Pop(&bucket[i]).(int)
			fmt.Println("heap.Pop(&bucket[i]).(int) at index", index, "is", arr[index])
			index++
		}
	}
}

type IntArr []int

func (h IntArr) Len() int           { return len(h) }
func (h IntArr) Less(i, j int) bool { return h[i] < h[j] }
func (h IntArr) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntArr) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntArr) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}
