package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubtree(s *TreeNode, t *TreeNode) bool {
	return checkIfSubtree(s, t, false)
}

func checkIfSubtree(s *TreeNode, t *TreeNode, isPartial bool) bool {
	if (s == nil && t != nil) || (s != nil && t == nil) {
		return false
	}
	if s == nil && t == nil {
		return true
	}
	if t.Val == s.Val && checkIfSubtree(s.Left, t.Left, true) && checkIfSubtree(s.Right, t.Right, true) {
		return true
	}

	if isPartial {
		return false
	}
	return checkIfSubtree(s.Left, t, false) || checkIfSubtree(s.Right, t, false)
}
