package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	return getHeight(root) != -1
}

func getHeight(root *TreeNode) float64 {
	if root == nil {
		return 0
	}
	left := getHeight(root.Left)
	right := getHeight(root.Right)
	if left == -1 || right == -1 || math.Abs(left-right) > 1 {
		return -1
	}
	return 1 + math.Max(left, right)
}
