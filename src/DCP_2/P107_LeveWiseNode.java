/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Microsoft
 * @author SHUBHAM
 * Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.
    1
   / \
  2   3
     / \
    4   5
 */
public class P107_LeveWiseNode 
{
    static class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        printLevelNode(root);
    }
    private static void printLevelNode(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) 
            {
                q.add(temp.left);
            }
            if (temp.right != null) 
            {
                q.add(temp.right);
            }
        }
    }
}
