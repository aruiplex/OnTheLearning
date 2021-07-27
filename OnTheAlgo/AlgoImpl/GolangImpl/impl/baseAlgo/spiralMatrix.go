package impl

/*

59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

示例 1：

输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]

提示：

1 <= n <= 20

------------------------------------------

思路:

和昨天的题很像, 只不过是一个逆过程. 仍然按照4个 boundary 来解决.

*/
func generateMatrix(n int) [][]int {
	// answer generated matrix
	ans := make([][]int, n)
	for i := 0; i < n; i++ {
		ans[i] = make([]int, n)
	}

	// finish signal, this matrix at most has n*n elements
	fin := n * n

	// 4 direction boundary index
	top := 0
	bottom := n - 1
	left := 0
	right := n - 1

	// assgin value to variable
	currNum := 1

	for currNum <= fin {
		for i := left; i <= right; i++ {
			ans[top][i] = currNum
			currNum++
		}
		top++
		for i := top; i <= bottom; i++ {
			ans[i][right] = currNum
			currNum++
		}
		right--
		for i := right; i >= left; i-- {
			ans[bottom][i] = currNum
			currNum++
		}
		bottom--
		for i := bottom; i >= top; i-- {
			ans[i][left] = currNum
			currNum++
		}
		left++
	}
	return ans
}
