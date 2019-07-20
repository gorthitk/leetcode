/**
 * @param {number[]} nums
 * @return {number[][]}
 */
const threeSum = function (nums) {
    const len = nums.length;

    // sort the array
    nums.sort(sort);

    // result which is returned.
    const result = [];


    for (let i = 0; i < len - 2; i++) {
        if (i !== 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        const a = nums[i];
        let j = i + 1;
        let k = len - 1;

        while (j < k) {

            let b = nums[j];
            let c = nums[k];

            const sum = a + b + c;
            if (sum === 0) {
                result.push([a, b, c]);
                j++;
                k--;
                while (j < k && nums[j] === nums[j - 1]) {
                    j++;
                }

                while (j < k && nums[k] === nums[k + 1]) {
                    k--;
                }
            } else if (sum > 0) {
                k--;
            } else {
                j++;
            }
        }
    }

    // return result.
    return result;
};

const sort = (a, b) => {
    if (a === b) {
        return 0;
    }

    return a > b ? 1 : -1;
};