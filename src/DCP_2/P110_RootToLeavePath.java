/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Facebook
 * @author SHUBHAM
 * Given a binary tree, return all paths from the root to leaves.
    For example, given the tree
       1
      / \
     2   3
        / \
       4   5

    it should return [[1, 2], [1, 3, 4], [1, 3, 5]].
 */
public class P110_RootToLeavePath 
{
    static class Node
    {
        int data;
        Node right, left;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static List<List<Node>> paths = new ArrayList<>();
    static List<Node> l = new ArrayList<>();
    public static void main(String[] args) 
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        getPath(root);
        paths.forEach(e -> System.out.println(e.stream().filter(Objects::nonNull).map(t->t.data).collect(Collectors.toList())));
//        for (int i = 0; i < paths.size(); i++) 
//        {
//            List<Node> l = paths.get(i);
//            List<Integer> l2 = new ArrayList<>();
//            for (int j = 0; j < l.size(); j++) 
//            {
//                Node n = l.get(j);
//                if (n != null) 
//                {
//                    int k = n.data;
//                    l2.add(k);
//                }
//            }
//            System.out.println(l2);
//        }
    }
    private static List<List<Node>> getPath(Node root)
    {
        int path[] = new int[1000];
        printPathsRecur(root, path, 0);
        return paths;
    }
    static void printPathsRecur(Node node, int path[], int pathLen)  
    { 
        if (node == null) 
            return; 
   
        /* append this node to the path array */
        path[pathLen] = node.data; 
        pathLen++; 
   
        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) 
            printArray(path, pathLen); 
        else 
        { 
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        } 
    } 
   static void printArray(int ints[], int len)  
    { 
        int i; 
        for (i = 0; i < len; i++)  
        { 
            System.out.print(ints[i] + " "); 
        } 
        System.out.println(""); 
    }
}
