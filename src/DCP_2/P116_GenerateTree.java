/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.Random;

/**
 * Jane Street
 * @author SHUBHAM
 * Generate a finite, but an arbitrarily large binary tree quickly in O(1).
    That is, generate() should return a tree whose size is unbounded but finite.
 */
public class P116_GenerateTree 
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
    static Node root;
    static Random rand = new Random();
    public static void main(String[] args) 
    {
        generate();
        traverseInOrder(root);
    }
    private static Node generate()
    {
        root = new Node(0);
        if (rand.nextInt() < 0.5) {
            root.left = generate();
        }
        if (rand.nextInt() < 0.5) {
            root.right = generate();
        }
        return root;
    }
    private static void traverseInOrder(Node root){
        if (root.left != null) {
            traverseInOrder(root.left);
        }
        System.out.print( root.data + ", ");
        if (root.right!=null) {
            traverseInOrder(root.right);
        }
    }
}
