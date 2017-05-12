package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	postOrderIdx := len(postorder) - 1

	if postOrderIdx == -1 {
		return nil
	}
	root := &TreeNode{Val: postorder[postOrderIdx], Left: nil, Right: nil}

	rootIdx := 0
	for inorder[rootIdx] != postorder[postOrderIdx] {
		rootIdx++
	}
	root.Left = buildTree(inorder[:rootIdx], postorder[:rootIdx])
	root.Right = buildTree(inorder[rootIdx+1:], postorder[rootIdx:postOrderIdx])
	return root
}
