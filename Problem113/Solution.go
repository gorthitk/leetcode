package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	var result [][]int
	var path []int
	getPath(root, sum, path, &result)
	return result
}

func getPath(root *TreeNode, sum int, path []int, result *[][]int) {
	if root == nil {
		return
	}
	path = append(path, root.Val)
	if sum == root.Val && root.Left == nil && root.Right == nil {
		*result = append(*result, path)
		return
	}
	leftPath := make([]int, len(path))
	RightPath := make([]int, len(path))

	copy(leftPath, path)
	copy(RightPath, path)
	getPath(root.Left, sum-root.Val, leftPath, result)
	getPath(root.Right, sum-root.Val, RightPath, result)
}
