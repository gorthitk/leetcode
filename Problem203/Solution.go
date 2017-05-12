package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	dummy := &ListNode{Val: -1, Next: nil}
	p := dummy
	for head != nil {
		if head.Val != val {
			p.Next = head
			p = p.Next
		}
		head = head.Next
	}
	//Tail
	if p.Next != nil && p.Next.Val == val {
		p.Next = nil
	}
	return dummy.Next
}
