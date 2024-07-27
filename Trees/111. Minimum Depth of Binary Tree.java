/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // If it's a leaf node, return depth as 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Recursively find the minimum depth of the left and right subtrees
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        // Return the minimum depth of the two subtrees plus 1 for the current node
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
