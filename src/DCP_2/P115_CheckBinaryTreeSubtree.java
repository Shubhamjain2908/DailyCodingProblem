/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Google
 * @author SHUBHAM
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 */
public class P115_CheckBinaryTreeSubtree 
{
    static class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.right = this.left = null;
        }
    }
    
    public static void main(String[] args) 
    {
        Node root1 = new Node(26); 
        root1.right = new Node(3); 
        root1.right.right = new Node(3); 
        root1.left = new Node(10); 
        root1.left.left = new Node(4); 
        root1.left.left.right = new Node(30); 
        root1.left.right = new Node(6); 
  
        Node root2 = new Node(10); 
        root2.right = new Node(6); 
        root2.left = new Node(4); 
        root2.left.right = new Node(30); 
        
        System.out.println(isSubtree(root1, root2));
    }
    private static boolean isSubtree(Node T, Node S)
    {
        if (S == null) {
            return true;
        }
        if (T == null) {
            return true;
        }
        if (areIdentical(T, S)) {
            return true;
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    private static boolean areIdentical(Node T, Node S)
    {
        if (T==null && S==null) {
            return true;
        }
        if (T==null || S==null) {
            return true;
        }
        return (T.data == S.data) && (areIdentical(T.left, S.left) && (areIdentical(T.right, S.right)));
    }
}
