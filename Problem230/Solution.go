package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

var smallestNum int

func kthSmallest(root *TreeNode, k int) int {
	getSmallest(root, k, 0)
	return smallestNum
}

func getSmallest(root *TreeNode, k int, curr int) int {
	if root == nil {
		return curr
	}
	curr = getSmallest(root.Left, k, curr)
	curr++
	if curr == k {
		smallestNum = root.Val
		return curr
	}

	return getSmallest(root.Right, k, curr)
}
