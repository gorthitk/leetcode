package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	slow := head
	fast := head
	var stack []int
	for fast != nil && fast.Next != nil {
		stack = append(stack, slow.Val)
		fast = fast.Next.Next
		slow = slow.Next
	}
	if fast != nil {
		slow = slow.Next
	}
	i := len(stack) - 1
	for slow != nil {
		top := stack[i]
		if slow.Val != top {
			return false
		}
		slow = slow.Next
		i--
	}
	return true
}
