package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return [][]int{}
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		numOfNodes := len(queue)
		var level []int
		for i := 0; i < numOfNodes; i++ {
			node := queue[0]
			level = append(level, node.Val)
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		result = append(result, level)
	}
	return result
}
