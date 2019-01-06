/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Google
 * @author SHUBHAM
 * Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.
    For example, given the following tree and K of 20
        10
       /   \
     5      15
           /  \
         11    15
    Return the nodes 5 and 15.

 */
public class P125_NodeSumK 
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(11);
        root.right.right = new Node(15);
        int k = 20;
        System.out.println(getNodes(root, k)[0].data + " : " + getNodes(root, k)[1].data);
    }
    static Map<Integer, List<Node>> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    private static Node[] getNodes(Node root, int k)
    {
        Node[] a = new Node[2];
        traverse(root);
        for (int i = 0; i < list.size(); i++) 
        {
            int j = list.get(i);
            if (map.containsKey(k-j)) 
            {
                a[0] = map.get(j).get(0);
                a[1] = map.get(k-j).get(0);
            }
        }
        return a;
    }
    private static void traverse(Node root)
    {
        int i = root.data;
        list.add(i);
        List<Node> l = new ArrayList<>();
        l.add(root);
        if (map.containsKey(i)) {
            l.addAll(map.get(i));
        }
        map.put(i, l);
        
        if (root.left != null) {
            traverse(root.left);
        }
        if (root.right != null) {
            traverse(root.right);
        }
    }
}
