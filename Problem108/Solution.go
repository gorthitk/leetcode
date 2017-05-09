package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	if nums == nil || len(nums) == 0 {
		return nil
	}
	return getBST(nums, 0, len(nums)-1)
}

func getBST(nums []int, start int, end int) *TreeNode {
	if start > end {
		return nil
	}
	mid := start + (end-start)/2
	root := TreeNode{Val: nums[mid]}
	root.Left = getBST(nums, start, mid-1)
	root.Right = getBST(nums, mid+1, end)
	return &root
}
