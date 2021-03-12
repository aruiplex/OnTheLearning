package impl

func MySqrt(x int) int {
	// 偷懒法
	// return int(math.Sqrt(float64(x)))

	// 二分法
	if x == 0 {
		return 0
	}
	left, right := 1, x/2
	for left < right {
		mid := (left+right)/2 + 1
		if mid > x/mid {
			right = mid - 1
		} else {
			left = mid
		}
	}
	return int(left)
}

// n is tested num, x is ans
// func checkCerrect(n, x int) bool {
// 	return (n-1)^2 < x && x < (n+1)^2
// }
