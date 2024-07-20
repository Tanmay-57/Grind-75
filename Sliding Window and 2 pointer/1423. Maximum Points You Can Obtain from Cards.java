class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0, rightSum = 0, maxSum = 0;

        // Calculate the initial sum of the first k elements
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        
        maxSum = leftSum; // Initialize maxSum with the initial leftSum

        // Now try to take elements from the right side
        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - 1 - i]; // Remove from the left
            rightSum += cardPoints[n - 1 - i]; // Add from the right
            maxSum = Math.max(maxSum, leftSum + rightSum); // Update maxSum
        }

        return maxSum;
    }
}
