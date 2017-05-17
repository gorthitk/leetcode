package main

func PredictTheWinner(nums []int) bool {

	return getMaxSum(nums, 0, len(nums)-1) >= 0
}

func getMaxSum(nums []int, start int, end int) int {
	if start == end {
		return nums[start]
	}
	sum_start := nums[start] - getMaxSum(nums, start+1, end)
	sum_end := nums[end] - getMaxSum(nums, start, end-1)
	if sum_start > sum_end {
		return sum_start
	}
	return sum_end
}
