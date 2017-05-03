func numberOfArithmeticSlices(A []int) int {
    if A == nil || len(A) < 3 {
    	return 0;
    }
    n := len(A);
    dp := make([]int, n);
    dp[0] = 0;
    dp[1] = 0;
    diff := A[1] - A[0];
    start := 0;
    for i:=2; i < n; i++ {
    	currDiff := A[i] - A[i-1];
    	if currDiff == diff {
    		dp[i] = dp[i-1] + 1 + (i-2-start);
    	} else {
    		dp[i] = dp[i-1];
    		start = i-1;
    		diff = currDiff;
    	}
    }
    return dp[n-1];
}