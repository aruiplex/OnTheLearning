package impl

// type NumMatrix struct {
// 	Matrix [][]int
// }

// func Constructor(matrix [][]int) NumMatrix {
// 	numMatrix := new(NumMatrix)
// 	numMatrix.Matrix = matrix
// 	return *numMatrix
// }

// func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
// 	sum := 0
// 	for i := row1; i <= row2; i++ {
// 		for j := col1; j <= col2; j++ {
// 			sum += this.Matrix[i][j]
// 		}
// 	}
// 	return sum
// }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */

/*
思路比较简单
但是有一些技巧还是挺有意思的:
1. 多次调用的函数尽减少复杂度, 把复杂度放在调用较少的函数上.
2. 虽然总体的复杂度上升了, 但是时间和空间都是大幅度减少.
3. 这就是一个简单的缓存效果.
4. 这道题用到的缓存就是把每一行的和都加起来, 类似于积分效果
5. 每一次调用的时候剪一下就行了.
*/
type NumMatrix struct {
	numArray [][]int
}

func ConstructorNumMatrix(matrix [][]int) NumMatrix {
	if len(matrix) == 0 {
		return NumMatrix{[][]int{}}
	}
	m, n := len(matrix), len(matrix[0])
	array := make([][]int, m)
	for i := 0; i < m; i++ {
		array[i] = append(array[i], matrix[i][0])
		for j := 1; j < n; j++ {
			array[i] = append(array[i], matrix[i][j]+array[i][j-1])
		}
	}
	return NumMatrix{array}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	sum := 0
	for i := row1; i <= row2; i++ {
		if col1 == 0 {
			sum += this.numArray[i][col2]
		} else {
			sum += this.numArray[i][col2] - this.numArray[i][col1-1]
		}
	}
	return sum
}
