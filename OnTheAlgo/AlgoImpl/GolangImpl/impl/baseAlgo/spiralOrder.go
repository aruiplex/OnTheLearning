package impl

/*

54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

题目解释:

从这个矩阵的外围依次遍历到矩阵的内部.

*/

func spiralOrder(matrix [][]int) (order []int) {
	// column number
	col := len(matrix[0])
	// row number
	row := len(matrix)
	// Total numbers of matrix
	eleNum := col * row
	// answer order
	// order = make([]int, eleNum)
	order = []int{}

	// boundary index
	top := 0
	left := 0
	bottom := row - 1
	right := col - 1

	for eleNum > 0 {
		// every time should check if there has enough eleNum to traverse
		for i := left; i <= right && eleNum > 0; i++ {
			order = append(order, matrix[top][i])
			eleNum--
		}
		top++
		for i := top; i <= bottom && eleNum > 0; i++ {
			order = append(order, matrix[i][right])
			eleNum--
		}
		right--
		for i := right; i >= left && eleNum > 0; i-- {
			order = append(order, matrix[bottom][i])
			eleNum--
		}
		bottom--
		for i := bottom; i >= top && eleNum > 0; i-- {
			order = append(order, matrix[i][left])
			eleNum--
		}
		left++
	}
	return
}
