package tools

// 怎么用递归写二分?
// func BinarySearch(arr []int, target int) int {

// 	mid := len(arr) / 2
// 	index := -1

// 	if len(arr) != 1 {
// 		if arr[mid] == target {
// 			return mid
// 		}

// 		if arr[mid] > target {
// 			index = BinarySearch(arr[:mid], target)
// 		} else {
// 			index += mid
// 			index = BinarySearch(arr[mid:], target)
// 		}
// 	}

// 	return index
// }

// BinarySearch 使用两个限制来确定搜索的上下界
func BinarySearch(nums []int, target int) int {
	low, high := 0, len(nums)-1
	mid := 0
	for low <= high {
		mid = (low + high) >> 1
		if target == nums[mid] {
			return mid
		}
		if nums[mid] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}

// todo 循环方式的二分, leetcode 上的示例, 没搞懂为什么比我的快
func search(arr []int, target int) int {
	len := len(arr)
	low := 0
	high := len
	var mid int

	for low < high {
		mid = low + (high-low)>>1
		if target > arr[mid] {
			low = mid + 1
		} else if target < arr[mid] {
			high = mid
		} else {
			return mid
		}
	}

	if target == arr[mid] && mid != len {
		return mid
	}

	return -1
}

// FindMinMax return min and max element of int array
func FindMinMax(arr []int) (int, int) {
	min, max := 1000000, 0
	for _, v := range arr {
		if v < min {
			min = v
		}
		if v > max {
			max = v
		}
	}
	return min, max
}
