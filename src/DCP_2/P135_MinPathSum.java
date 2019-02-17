/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Apple
 * @author SHUBHAM
 * Given a binary tree, find a minimum path sum from root to a leaf.
    For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.
      10
     /  \
    5    5
     \     \
       2    1
           /
         -1
 */
public class P135_MinPathSum 
{
    static class Node 
    {
        int data;
        Node right, left;
        Node(int data)
        {
            this.data = data;
            this.right = this.left = null;
        }
    }
    public static void main(String[] args) 
    {
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(5);
        root.left.right = new Node(2);
        root.right.right = new Node(1);
        root.right.right.left = new Node(-1); 
        P135_MinPathSum tree = new P135_MinPathSum();
        System.out.println("Following are the nodes "+ 
                        "on maximum sum path"); 
        int sum = tree.maxSumPath(); 
        System.out.println(""); 
        System.out.println("Sum of nodes is : " + sum); 
    }
    
    // A wrapper class is used so that max_no 
    // can be updated among function calls. 
    class Maximum 
    { 
        int max_no = Integer.MIN_VALUE; 
    }
    static Node root; 
    Maximum max = new Maximum(); 
    Node target_leaf = null; 
  
    // A utility function that prints all nodes on the 
    // path from root to target_leaf 
    boolean printPath(Node node, Node target_leaf) 
    { 
        // base case 
        if (node == null) 
            return false; 
  
        // return true if this node is the target_leaf or 
        // target leaf is present in one of its descendants 
        if (node == target_leaf || printPath(node.left, target_leaf) 
                || printPath(node.right, target_leaf)) 
        { 
            System.out.print(node.data + " "); 
            return true; 
        } 
  
        return false; 
    } 
  
    // This function Sets the target_leaf_ref to refer 
    // the leaf node of the maximum path sum. Also, 
    // returns the max_sum using max_sum_ref 
    void getTargetLeaf(Node node, Maximum max_sum_ref, 
                    int curr_sum) 
    { 
        if (node == null) 
            return; 
  
        // Update current sum to hold sum of nodes on 
        // path from root to this node 
        curr_sum = curr_sum + node.data; 
          
        // If this is a leaf node and path to this node 
        // has maximum sum so far, the n make this node 
        // target_leaf 
        if (node.left == null && node.right == null) 
        { 
            if (curr_sum > max_sum_ref.max_no) 
            { 
                max_sum_ref.max_no = curr_sum; 
                target_leaf = node; 
            } 
        } 
  
        // If this is not a leaf node, then recur down 
        // to find the target_leaf 
        getTargetLeaf(node.left, max_sum_ref, curr_sum); 
        getTargetLeaf(node.right, max_sum_ref, curr_sum); 
    } 
  
    // Returns the maximum sum and prints the nodes on 
    // max sum path 
    int maxSumPath() 
    { 
        // base case 
        if (root == null) 
            return 0; 
  
        // find the target leaf and maximum sum 
        getTargetLeaf(root, max, 0); 
  
        // print the path from root to the target leaf 
        printPath(root, target_leaf); 
        return max.max_no; // return maximum sum 
    } 
}
