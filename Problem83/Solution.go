package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	p := head
	for p != nil {
		next := p.Next
		for next != nil && next.Val == p.Val {
			next = next.Next
		}
		p.Next = next
		p = p.Next
	}
	return head
}
