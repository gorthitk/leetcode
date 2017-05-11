package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

var leftMostLvl int
var leftMostVal int

func findBottomLeftValue(root *TreeNode) int {
	leftMostVal = 0
	leftMostLvl = -1
	getLeftMostVal(root, 0)
	return leftMostVal
}

func getLeftMostVal(root *TreeNode, currLvl int) {
	if root == nil {
		return
	}
	if currLvl > leftMostLvl && root.Left == nil && root.Right == nil {
		leftMostLvl = currLvl
		leftMostVal = root.Val
	}
	getLeftMostVal(root.Left, currLvl+1)
	getLeftMostVal(root.Right, currLvl+1)
}
