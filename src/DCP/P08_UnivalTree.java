/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 *  Google
 * @author SHUBHAM
 *  A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
    Given the root to a binary tree, count the number of unival subtrees.
    For example, the following tree has 5 unival subtrees:
       0
      / \
     1   0
        / \
       1   0
      / \
     1   1
 */
public class P08_UnivalTree 
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
           /* Let us construct the below tree 
                5 
              /   \ 
            4      5 
          /  \      \ 
         4    4      5 */
        Node root = new Node(5);
        root.left = new Node(4); 
        root.right = new Node(5); 
        root.left.left = new Node(4); 
        root.left.right = new Node(4); 
        root.right.right = new Node(5); 
        
        Node root2 = new Node(5);
        root2.left = new Node(5); 
        root2.right = new Node(5); 
        root2.left.left = new Node(5); 
        root2.left.right = new Node(5); 
        root2.right.right = new Node(5); 
        
        Count c = new Count();
        System.out.println(univalTree(root, c)); 
        Count c2 = new Count();
        System.out.println(univalTree(root2, c2)); 
    } 
    
    private static int univalTree(Node root, Count data)
    {   
        countUnival(root, data);
        return data.count;
    }
    
    private static boolean countUnival(Node root, Count data)
    {
        if(root == null)
            return true;
        
        boolean left = countUnival(root.left, data);
        boolean right = countUnival(root.right, data);
        
        if (left == false || right == false) {
            return false;
        }
        
        if (root.left != null && root.data != root.left.data) {
            return false; 
        }
            
        if (root.right != null && root.data != root.right.data) {
            return false; 
        }
        
        data.count++;
        
        return true;
    }
}
class Count  
{ 
    int count = 0; 
}