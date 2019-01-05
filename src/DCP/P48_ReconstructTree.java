/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Google
 * @author SHUBHAM
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
    For example, given the following preorder traversal:
    [a, b, d, e, c, f, g]
    And the following inorder traversal:
    [d, b, e, a, f, c, g]
    You should return the following tree:
        a
       / \
      b   c
     / \ / \
    d  e f  g
 */
public class P48_ReconstructTree 
{
    public static void main(String[] args) 
    {
//        String[] preOrder = {"a","b","d","e","c","f","g"}; 1,2,4,5,3,6,7
//        String[] inOrder  = {"d","b","e","a","f","c","g"}; 4,2,5,1,6,3,7
//        DCP48_Node tree = getTree(preOrder, inOrder);
        
        int in[] = new int[] { 4,2,5,1,6,3,7 }; 
        int pre[] = new int[] { 1,2,4,5,3,6,7 }; 
        int len = in.length; 
        P48_ReconstructTree p = new P48_ReconstructTree();
        DCP48_Node root= p.buildTree(pre, in);
        p.printInorder(root);
        System.out.println(" ");
        p.printPreorder(root);
        System.out.println(" ");
        //p.breadthSearch(root);
        p.depthSearch(root);
    }
    static Set<DCP48_Node> set = new HashSet<>(); 
    static Stack<DCP48_Node> stack = new Stack<>(); 
  
    // Function to build tree using given traversal 
    public DCP48_Node buildTree(int[] preorder, int[] inorder) 
    { 
  
        DCP48_Node root = null; 
        for (int pre = 0, in = 0; pre < preorder.length;) { 
  
            DCP48_Node node = null; 
            do { 
                node = new DCP48_Node(preorder[pre]); 
                if (root == null) { 
                    root = node; 
                } 
                if (!stack.isEmpty()) { 
                    if (set.contains(stack.peek())) { 
                        set.remove(stack.peek()); 
                        stack.pop().right = node; 
                    } 
                    else { 
                        stack.peek().left = node; 
                    } 
                } 
                stack.push(node); 
            } while (preorder[pre++] != inorder[in] && pre < preorder.length); 
  
            node = null; 
            while (!stack.isEmpty() && in < inorder.length && stack.peek().val == inorder[in]) { 
                node = stack.pop(); 
                in++; 
            } 
  
            if (node != null) { 
                set.add(node); 
                stack.push(node); 
            } 
        } 
  
        return root; 
    } 
    
    void breadthSearch(DCP48_Node node)
    {
        Queue<DCP48_Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            DCP48_Node n = q.poll();
            System.out.print(" " + n.val + " ");
            
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
            System.out.println(" ");
        }
    }
    
    void depthSearch(DCP48_Node node)
    {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.val + " ");
        depthSearch(node.left);
        depthSearch(node.right);
    }
    // Function to print tree in Inorder 
    void printInorder(DCP48_Node node) 
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.val + " "); 
        printInorder(node.right); 
    }
    void printPreorder(DCP48_Node node) 
    { 
        if (node == null) 
            return; 
        System.out.print(node.val + " "); 
        printInorder(node.left);
        printInorder(node.right); 
    }
    /*
    private static DCP48_Node getTree(String[] preOrder, String[] inOrder) 
    {
        String centreNode = preOrder[0];
        List<String> leftNodes = new ArrayList<>();
        List<String> rightNodes = new ArrayList<>();
        boolean isCentreAppeared = false;
        for (int i = 0; i < inOrder.length; i++) 
        {
            if (inOrder[i] == null ? centreNode == null : inOrder[i].equals(centreNode)) {
                isCentreAppeared = true;
            }
            if (!isCentreAppeared) {
                leftNodes.add(inOrder[i]);
            }
            if (isCentreAppeared && !inOrder[i].equals(centreNode)) {
                rightNodes.add(inOrder[i]);
            }
        }
        return null;
    }
    */
}
class DCP48_Node
{
    int val;
    DCP48_Node right,left;
    
    DCP48_Node(int data){ 
        this.val = data; 
        left = null; 
        right = null; 
    } 
}