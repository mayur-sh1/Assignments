class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1]; // Tracks number of nodes visited
        int[] res = new int;   // Stores k-th smallest value
        inOrder(root, k, res, count);
        return res;
    }

    // In-order traversal: left -> node -> right
    private void inOrder(TreeNode root, int k, int[] res, int[] count) {
        if (root == null) return;

        inOrder(root.left, k, res, count);

        count++;
        if (count == k) {
            res = root.val;  // Found k-th smallest element
            return;
        }

        inOrder(root.right, k, res, count);
    }
}