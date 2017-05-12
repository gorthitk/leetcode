package main

type TreeNode struct {
	Val   int
	Left  TreeNode
	Right TreeNode
}

var max int

func findFrequentTreeSum(root *TreeNode) []int {
	max = 0
	var result []int
	counts := map[int]int{}
	getCounts(root, &counts)
	for k, v := range counts {
		if v == max {
			result = append(result, k)
		}
	}
	return result
}

func getCounts(root *TreeNode, counts *map[int]int) int {
	if root == nil {
		return 0
	}
	var sum int
	var count int
	sum = root.Val + getCounts(root.Left, counts) + getCounts(root.Right, counts)

	count = (*counts)[sum]
	(*counts)[sum] = count + 1
	max = getMax(max, (*counts)[sum])
	return sum
}

func getMax(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
