/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Apple
 * @author SHUBHAM
 * Given a tree, find the largest tree/subtree that is a BST.
 * Given a tree, return the size of the largest tree/subtree that is a BST.
 */
public class P93_ValidBST 
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
    
    public static void main(String[] args) 
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
        
        P93_ValidBST p1 = new P93_ValidBST();
        System.out.println(p1.size(root));
        P93_ValidBST p2 = new P93_ValidBST();
        System.out.println(p2.size(root2));
        P93_ValidBST p3 = new P93_ValidBST();
        System.out.println(p3.size(root3));
        
    }
    private boolean isValid(Node root)
    {
        return isValid_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValid_helper(Node root, int min, int max)
    {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isValid_helper(root.left, min, root.data -1) && isValid_helper(root.right, root.data + 1, max);
    }
    private int size(Node root)
    {
        if (root == null) 
        {
            return 0;
        }
        if (!isValid(root)) {
            return Math.max(size(root.left), size(root.right));
        }
        return size(root.left) + 1 + size(root.right);
    }
}
