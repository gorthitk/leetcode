package main

import (
	"math"
)

func minimumTotal(triangle [][]int) int {
	n := len(triangle)
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
	}

	for i := 0; i < n; i++ {
		dp[0][i] = triangle[n-1][i]
	}

	k := 0
	for i := n - 2; i >= 0; i-- {

		for j := 0; j < i+1; j++ {
			if dp[k][j] > dp[k][j+1] {
				dp[k+1][j] = dp[k][j+1] + triangle[i][j]
			} else {
				dp[k+1][j] = dp[k][j] + triangle[i][j]
			}
		}
		k++
	}
	return dp[n-1][0]
}
