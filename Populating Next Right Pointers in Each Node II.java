/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    //goal: link nodes in the same layer 
    //using 2 pointers to record the position of the parents node and the child node which should be connected
    public Node connect(Node root) {
        if(root == null) return root;
        Node head = null;  //head node of next level, to cache a position. so we can go to the next level
        Node cur = root;  //the null after each layer is connected to the last node automatically 
        Node prev = null;  //prev node of next level, link the new node aftet it 
        while(cur != null){  //make sure it goes thru the whole thing.
            while(cur!= null){  //each layer, need to check whether it is a new layer or not 
                if(cur.left != null){ 
                    if(prev == null){
                        head = cur.left;  //if prev is null means it is a new layer need to be done, i.e. it is the begining
                        prev = cur.left;
                    }
                    else{
                        prev.next = cur.left;
                        prev = prev.next;//update position it doesnt matter if prev == null or what
                    }
                }
                if(cur.right != null){
                    if(prev == null) head = cur.right; 
                    else prev.next = cur.right;
                    prev = cur.right;  // cannot be prev = prev.next since when prev == null it would throw NullPointerException
                }
                cur = cur.next;  //to the next parents node at the last leayer 
            }
            cur = head;  //on to the next layer
            head = null;
            prev = null;
        }
        return root;
    }
}

//BFS
//do not need a que to store the node 
