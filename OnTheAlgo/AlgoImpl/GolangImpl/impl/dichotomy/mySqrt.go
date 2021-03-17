package impl

/*

69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

通过次数273,714提交次数697,533

---------------------------------------------------------

比较经典的用二分查找来得出 1/2 次方.

但是二分法这个东西写出来 90% 的东西都不难, 难就难在最后的一点边界处理的问题 .

+1 / -1 之类的问题 .

*/
func MySqrt(x int) int {
	// 偷懒法
	// return int(math.Sqrt(float64(x)))

	// 二分法
	if x == 0 {
		return 0
	}
	// 二分法基本上都是通过两个边界来确定, 下一次要在的范围
	// 每一次都把 left 或者 right 移动一半, 就起到了二分的作用
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
