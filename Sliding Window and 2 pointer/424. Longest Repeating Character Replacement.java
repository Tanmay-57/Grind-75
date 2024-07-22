class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26]; // To store the count of each character
        int left = 0, right = 0, maxf = 0, maxLength = 0;

        // Slide the window
        while (right < s.length()) {
            // Increment the count of the current character
            hash[s.charAt(right) - 'A']++;
            // Find the count of the most frequent character in the current window
            maxf = Math.max(maxf, hash[s.charAt(right) - 'A']);

            // Check if the current window is valid
            if ((right - left + 1) - maxf > k) {
                // If not valid, slide the left window
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length of valid window
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
