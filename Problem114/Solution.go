package main

type TreeNode struct {
	Val int
	LeftTreeNode
	RightTreeNode
}

func flatten(root *TreeNode) {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return
	}
	flatten(root.Left)
	flatten(root.Right)
	currRight := root.Right
	root.Right = root.Left
	root.Left = nil
	for root.Right != nil {
		root = root.Right
	}
	root.Right = currRight
}
