/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.HashMap;
import java.util.Map;

/**
 * Google
 * @author SHUBHAM
 * Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.
    a
   / \
  b   c
 /
d
 */
public class P80_DeepestNode 
{
    static class Node
    {
        String data;
        Node left, right;
        public Node(String data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static void main(String[] args) 
    {
        Node root = new Node("1"); 
        root.left = new Node("2"); 
        root.right = new Node("3"); 
        root.left.left = new Node("4"); 
        root.right.left = new Node("5"); 
        root.right.right = new Node("6"); 
        root.right.left.right = new Node("7"); 
        root.right.right.right = new Node("8"); 
        root.right.left.right.left = new Node("9"); 
        
        Node root2 = new Node("a");
        root2.right = new Node("c");
        root2.left = new Node("b");
        root2.left.left = new Node("d");
        
        Node root3 = new Node("1"); 
        root3.left = new Node("2"); 
        root3.right = new Node("3"); 
        root3.left.left = new Node("4"); 
        root3.left.right = new Node("5");
        root3.right.left = new Node("6"); 
        root3.right.right = new Node("7"); 
        root3.right.right.right = new Node("8"); 
        
        System.out.println(deepestNode(root));
        System.out.println(deepestNode(root2));
        System.out.println(deepestNode(root3));
    }
    
    private static String deepestNode(Node root)
    {
        Map<Node, Integer> map = new HashMap<>();
        Map<Node, Integer> m = deep(root, map, 0);
        m.entrySet().forEach(e -> System.out.println(e.getKey().data + " -> " + e.getValue()));
        return m
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get().getKey().data;
    }
    private static Map<Node, Integer> deep(Node root, Map<Node, Integer> map, int level)
    {
        map.put(root, level);
        if (root.left != null) {
            deep(root.left, map, level+1);
        }
        if (root.right != null) {
            deep(root.right, map, level+1);
        }
        return map;
    }
}
