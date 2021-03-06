class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode[] pre = new TreeNode[1];  //cache the prev root position, need to be an array otherwise the pre value wont be recorded
        convert(root, pre);
    }
    private void convert(TreeNode root, TreeNode[] pre){ //convert the right node and the left node of the root
        if(root == null) return;  //leaf node 
        convert(root.right, pre);  //find leaf node 
        convert(root.left, pre);
        root.right = pre[0];  //link it with the prev root
        root.left = null;  //cut the link with the prev root
        pre[0] = root; //same as return root
    }
}

//tree, recursion
//starts from right to left. if the right leaf node is not null then move it under the left leaf node 
//and then move the prev left leaf node to the right side of the root


//stack
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null){
                cur.right = cur.left;
                cur.left = null;
            }
            else if(!stack.empty()){
                TreeNode top = stack.pop();
                cur.right = top;
            }
            cur = cur.right;
        }
    }
}
