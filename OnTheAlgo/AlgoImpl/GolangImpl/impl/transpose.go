package impl

// matrixTrans[j][i] = matrix[i][j]
// 求转置矩阵
func Transpose(matrix [][]int) [][]int {
	matrixTrans := [][]int{}
	row := []int{}
	columnLength := len(matrix)
	rowLength := len(matrix[0])

	for i := 0; i < rowLength; i++ {
		for j := 0; j < columnLength; j++ {
			row = append(row, matrix[j][i])
		}
		matrixTrans = append(matrixTrans, row)
		row = []int{}
	}

	return matrixTrans
}

// func TransposeMain() {
// 	matrix := [][]int{
// 		{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 2, 3},
// 	}

// 	matrixTrans := impl.Transpose(matrix)
// 	fmt.Println(matrixTrans)
// }
