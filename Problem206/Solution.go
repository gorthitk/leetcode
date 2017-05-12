package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	node := head.Next
	head.Next = nil
	reverse = reverseList(node)
	node.Next = head
	return reverse
}
