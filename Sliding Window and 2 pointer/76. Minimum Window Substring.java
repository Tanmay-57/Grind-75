class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // Create a dictionary to store the frequency of characters in `t`
        int[] dict = new int[128];
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i)]++; // Increment frequency of each character in `t`
        }

        int required = t.length();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            // If the current character is in `t`, decrement the required count
            if (dict[s.charAt(right)] > 0) {
                required--;  // Decrement frequency of the current character
            }
            dict[s.charAt(right)]--;

            while (required == 0) {
                // Update the minimum window if the current window is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                // Move the left pointer to the right to shrink the window
                dict[s.charAt(left)]++;
                if (dict[s.charAt(left)] > 0) {
                    // If the character at the left pointer is in `t`, increment the required count
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
