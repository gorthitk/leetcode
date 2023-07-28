class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0;
        int start = 0;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum * (i - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }

            // Number of subarrays that include the number at index 'i'
            // and that fit this requirement is equal to the length.
            // Example : [1,2,3] the subarrays that satify this requirement and include number at index i
            // are [1,2,3] & [2,3]
            // for length n [1,2,...n] the subarrays are :
            // [1,2,...n] , [2,3,...,n], [3,4...,n] ..... [n - 1, n], [n]
            // total n subarrays.
            result += (i - start + 1);
        }

        return result;
    }
}