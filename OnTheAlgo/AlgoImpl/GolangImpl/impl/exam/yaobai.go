package impl

import "fmt"

func m() {
	t := 0
	fmt.Scan(&t)
	arr := []int{}
	el := 0
	for i := 0; i < t; i++ {
		fmt.Scan(&el)
		arr = append(arr, el)
	}
}

// func yaobaiArr(arr []int) int {
// 	if len(arr) == 0 || len(arr) == 1 {
// 		return 0
// 	}
// 	arrList := [][]int{}
// 	// 上一个相等的点
// 	last := 0
// 	// 元素相等的次数
// 	eqTimes := 0
// 	for i := 0; i < len(arr)-1; i++ {
// 		if arr[i] == arr[i+1] {
// 			arrList = append(arrList, arr[last:i])
// 			last = i + 2
// 			eqTimes++
// 		}
// 	}
// 	if eqTimes == 0 {
// 		arrList = append(arrList, arr)
// 	}
// 	// 单调性
// 	up := 0
// 	down := 0
// 	// 目前最长子数组
// 	currMax := 0
// 	// 递增的上一个数
// 	lastUp := -100000000
// 	// 递减的上一个数
// 	lastDown := 100000000
// 	// 遍历二位数组
// 	for i := 0; i < len(arrList); i++ {
// 		for j := 1; j < len(arrList[i]); j++ {

// 			if arrList[i][j-1] < arrList[i][j] && arrList[i][j] > lastUp {
// 				up++
// 				lastUp = arrList[i][j]
// 				continue
// 			}

// 			if arrList[i][j-1] > arrList[i][j] && arrList[i][j] < lastDown {
// 				down++
// 				lastDown = arrList[i][j]
// 			}

// 		}
// 		if up >= 2 && down >= 2 {
// 			currMax = max(len(arrList[i]), currMax)
// 		}
// 		up = 0
// 		down = 0
// 	}

// 	return currMax
// }

func yaobaiArr(arr []int) int {
	if len(arr) == 0 || len(arr) == 1 {
		return 0
	}
	arrList := [][]int{}
	// 上一个相等的点
	last := 0
	// 元素相等的次数
	eqTimes := 0
	for i := 1; i < len(arr)-1; i++ {
		if arr[i] == arr[i+1] || (arr[i-1] > arr[i] && arr[i] < arr[i+1]) || (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
			arrList = append(arrList, arr[last:i])
			last = i + 2
			eqTimes++
		}
	}
	if eqTimes == 0 {
		arrList = append(arrList, arr)
	}
	// 单调性
	up := 0
	down := 0
	// 目前最长子数组
	currMax := 0
	// 递增的上一个数
	// lastUp := -100000000
	// // 递减的上一个数
	// lastDown := 100000000
	// 遍历二位数组
	for i := 0; i < len(arrList); i++ {
		for j := 1; j < len(arrList[i]); j++ {

			if arrList[i][j-1] < arrList[i][j] {
				up++
				continue
			}

			if arrList[i][j-1] > arrList[i][j] {
				down++

			}

		}
		if up >= 2 && down >= 2 {
			currMax = max(len(arrList[i]), currMax)
		}
		up = 0
		down = 0
	}

	return currMax
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
