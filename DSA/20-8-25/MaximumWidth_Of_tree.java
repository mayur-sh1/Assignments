class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0; 
        Queue q = new LinkedList<>();
        q.offer(new Pair(root, 0)); 

        // Perform BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();

            // The minimum index at this level to  avoid overflow       
            int mmin = q.peek().index;

            int first = 0, last = 0; 

            // Traverse the entire level
            for (int i = 0; i < size; i++) {
                int cur_index = q.peek().index - mmin; // normalize index
                TreeNode node = q.peek().node;
                q.poll();

                // Set first and last node indices of current level
                if (i == 0) first = cur_index;      // first node in level
                if (i == size - 1) last = cur_index; // last node in level

                // Push children into queue with updated indices
                if (node.left != null)
                    q.offer(new Pair(node.left, cur_index * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, cur_index * 2 + 2));
            }

            // Update the answer with max width so far
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}}
