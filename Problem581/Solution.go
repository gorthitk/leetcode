package main

func findUnsortedSubarray(nums []int) int {
	var end int
	var start int
	var max int
	start = len(nums)
	end = -1
	max = nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] < max {
			end = getMax(end, i)
			position := i - 1
			num := nums[i]
			for position >= 0 && num < nums[position] {
				position--
			}
			start = getMin(start, position)
		} else {
			max = nums[i]
		}

	}
	if end == -1 {
		return 0
	}
	return end - start
}

func getMax(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func getMin(a int, b int) int {
	if a > b {
		return b
	}
	return a
}
