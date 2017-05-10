package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rightSideView(root *TreeNode) []int {
	var result []int
	populateRightSideView(root, &result, 0)
	return result
}

func populateRightSideView(root *TreeNode, result *[]int, level int) {
	if root == nil {
		return
	}
	if level == len(*result) {
		*result = append(*result, root.Val)
	}
	populateRightSideView(root.Right, result, level+1)
	populateRightSideView(root.Left, result, level+1)
}
