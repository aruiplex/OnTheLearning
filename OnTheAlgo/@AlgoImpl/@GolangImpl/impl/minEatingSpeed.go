package impl

import (
	"math"
)

func MinEatingSpeed(piles []int, h int) int {
	// 二分搜索范围, 对应 *最慢* 和 *最快* 吃香蕉的速度
	low := 1
	high := FindMinMax(piles)
	// 吃香蕉的速度
	k := 1
	for low < high {
		// 当前使用的时间
		time := 0
		k = (low + high) >> 1
		for i := 0; i < len(piles); i++ {
			time += int(math.Ceil(float64(piles[i]) / float64(k)))
		}
		// todo 这是重点
		if time > h {
			low = k + 1
		} else {
			high = k - 1
		}
	}
	// 二分查找, 但是不能用中值, 要用下值
	return low
}

func FindMinMax(arr []int) int {
	max := 0
	for _, v := range arr {
		if v > max {
			max = v
		}
	}
	return max
}
