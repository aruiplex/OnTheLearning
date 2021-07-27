package impl

import "aruix.net/code/algo/tools"

// first O(m+n) method
func FindMedianSortedArraysOMN(nums1 []int, nums2 []int) float64 {
	nums := append(nums1, nums2...)
	nums = tools.QuickSort(nums)
	p := float64(len(nums)+1)/2 - 1
	if len(nums) == 1 {
		return float64(nums[0])
	}

	if float64(int(p)) != p {
		return (float64(nums[len(nums)/2-1]) + float64(nums[len(nums)/2])) / 2
	}
	return float64(nums[len(nums)/2])
}

// func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
// 	l1 := len(nums1) / 2.0
// 	l2 := len(nums2) / 2.0

// }

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
