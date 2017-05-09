package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, sum int) int {
	if root == nil {
		return 0
	}
	return getCount(root, sum) + pathSum(root.Left, sum) + pathSum(root.Right, sum)
}

func getCount(root *TreeNode, sum int) int {
	if root == nil {
		return 0
	}
	var count int = getCount(root.Left, sum-root.Val) + getCount(root.Right, sum-root.Val)
	if root.Val == sum {
		count++
	}
	return count
}
