/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Linkedin
 * @author SHUBHAM
 * Determine whether a tree is a valid binary search tree.
A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.
 */
public class P89_ValidBinaryTree 
{
    static class Node
    {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static void main(String args[]) 
    { 
        Node root = new Node(4); 
        root.left = new Node(2); 
        root.right = new Node(5); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        
        Node root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.left = new Node(4); 
        root2.right.left = new Node(5); 
        root2.right.right = new Node(6); 
        root2.right.left.right = new Node(7); 
        root2.right.right.right = new Node(8); 
        root2.right.left.right.left = new Node(9); 
        
        Node root3 = new Node(1); 
        root3.left = new Node(2); 
        root3.right = new Node(3); 
        root3.left.left = new Node(4); 
        root3.left.right = new Node(5);
        root3.right.left = new Node(6); 
        root3.right.right = new Node(7); 
        root3.right.right.right = new Node(8); 
        
        System.out.println(isBST(root));
        System.out.println(isBST(root2));
        System.out.println(isBST(root3));
    }
    private static boolean isBST(Node root) 
    {
        return bst_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean bst_helper(Node node, int min, int max)
    {
        if (node == null) {
            return true;
        }
        if (node.data < min || node.data > max) {
            return false;
        }
        return bst_helper(node.left, min, node.data - 1) && bst_helper(node.right, node.data+1, max);
    }
}
