package main

func updateMatrix(matrix [][]int) [][]int {
	row := len(matrix)
	col := len(matrix[0])
	max := row * col
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if matrix[i][j] != 0 {
				up := max
				left := max
				if i > 0 {
					up = matrix[i-1][j]
				}
				if j > 0 {
					left = matrix[i][j-1]
				}
				matrix[i][j] = 1 + min(up, left)
			}
		}
	}

	for i := row - 1; i >= 0; i-- {
		for j := col - 1; j >= 0; j-- {
			if matrix[i][j] != 0 {
				down := max
				right := max
				if i < row-1 {
					down = matrix[i+1][j]
				}
				if j < col-1 {
					right = matrix[i][j+1]
				}
				matrix[i][j] = min(1+min(down, right), matrix[i][j])
			}
		}
	}
	return matrix
}
func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}
