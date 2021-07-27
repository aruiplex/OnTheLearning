package impl

import "aruix.net/code/algo/tools"

// IsStraight leetcode question
func IsStraight(nums []int) bool {
	// array transfer to map
	// numsMap := ArrayTimes(nums)
	numsSort := tools.QuickSort(nums)
	// v is zero apparence times
	zeroTimes := 0

	for i := 0; i < len(numsSort)-1; i++ {
		// count zero times
		if numsSort[i] == 0 {
			zeroTimes++
			continue
		}
		// check obey the order
		if numsSort[i] == numsSort[i+1] {
			return false
		}
		if numsSort[i] != numsSort[i+1]-1 {
			zeroTimes -= (numsSort[i+1] - 1 - numsSort[i])
			if zeroTimes < 0 {
				return false
			}
		}
	}
	return true
}

// ArrayToMap return map by array
func ArrayToMap(array []int) map[int]struct{} {
	var empty struct{}
	numsMap := map[int]struct{}{}
	for _, v := range array {
		numsMap[v] = empty
	}
	return numsMap
}

// ArrayTimes return elements apparence times of an array
func ArrayTimes(array []int) map[int]int {
	numsMap := map[int]int{}
	for _, e := range array {
		numsMap[e]++
	}
	return numsMap
}
