class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeros = 0, maxLen = 0;

        // Use a sliding window 
        while (r < nums.length) {
            // If the current element is 0, increment the count of zeros
            if (nums[r] == 0) {
                zeros++;
            }

            // If the count of zeros exceeds k, shrink the window from the left
            if (zeros > k) {
                // If the element at the left pointer is 0, decrement the count of zeros
                if (nums[l] == 0) {
                    zeros--;
                }
                // Move the left pointer to the right
                l++;
            }

            // If the count of zeros is within the limit, update the maximum length
            if (zeros <= k) {
                int len = r - l + 1; // Calculate the length of the current window
                maxLen = Math.max(len, maxLen); // Update maxLen if the current window is longer
            }
            r++;
        }
        return maxLen; // Return the maximum length of the subarray found
    }
}
