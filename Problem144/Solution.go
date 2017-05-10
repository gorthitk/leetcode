package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	var list []int
	populatePreOrder(root, &list)
	return list
}

func populatePreOrder(root *TreeNode, list *[]int) {
	if root != nil {
		*list = append(*list, root.Val)
		populatePreOrder(root.Left, list)
		populatePreOrder(root.Right, list)
	}
}
