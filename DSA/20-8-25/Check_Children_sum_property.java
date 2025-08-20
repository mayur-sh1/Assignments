class Solution {
    public boolean isSumProperty(Node root) {
        // Base Case 1: If node is null, it's valid (empty tree is valid)
        if(root == null) return true;

        // Base Case 2: If it's a leaf node, it's valid by definition
        if(root.left == null && root.right == null) return true;

        
        int leftVal = (root.left != null) ? root.left.data : 0;
        int rightVal = (root.right != null) ? root.right.data : 0;

        // Does this node satisfy the children sum property?
        boolean res = (root.data == leftVal + rightVal);

        return res && isSumProperty(root.left) && isSumProperty(root.right);
    }
}