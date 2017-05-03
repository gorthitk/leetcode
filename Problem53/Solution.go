package Problem53

import (
	"fmt", "math"
)

func maxSubArray(nums []int) int {
    max := nums[0];
    localMax := nums[0];
    for i:=1; i < len(nums); i++ {
    	if localMax + nums[i] > nums[i] {
	    	localMax = localMax + nums[i];
    	} else {
    		localMax = nums[i]
    	}
    	
    	if localMax > max {
    		max = localMax;
    	}
    	
    }
    return max;
}

