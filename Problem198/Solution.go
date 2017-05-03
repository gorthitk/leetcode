
func rob(nums []int) int {
    if len(nums) == 0 {
        return 0;
    }
    if len(nums) == 1 {
    	return nums[0];
    }
    n := len(nums);
    dp := make([]int, n);
    dp[0] = nums[0];
    dp[1] = nums[1];
    if nums[0] > nums[1] {
    	dp[1] = nums[0];
    }
    for i := 2; i < n; i++ {
    	if dp[i-1] > nums[i] + dp [i-2] {
    		dp [i] = dp [i-1];
    	} else {
    		dp[i] = dp[i-2] + nums[i];
    	}
    }
    return dp[n-1];
}

