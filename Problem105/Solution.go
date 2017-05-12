package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	root := &TreeNode{Val: preorder[0], Left: nil, Right: nil}
	if len(preorder) == 1 {
		return root
	}
	rootIdx := 0
	for inorder[rootIdx] != preorder[0] {
		rootIdx++
	}
	root.Left = buildTree(preorder[1:rootIdx+1], inorder[:rootIdx])
	root.Right = buildTree(preorder[rootIdx+1:], inorder[rootIdx+1:])
	return root
}
