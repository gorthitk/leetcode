package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func hasPathSum(root *TreeNode, sum int) bool {
	if root == nil || (root.Left == nil && root.Right == nil && sum-root.Val != 0) {
		return false
	}
	return (root.Left == nil && root.Right == nil && sum-root.Val == 0) || hasPathSum(root.Left, sum-root.Val) || hasPathSum(root.Right, sum-root.Val)
}
