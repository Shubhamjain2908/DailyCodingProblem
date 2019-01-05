/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Facebook
 * @author SHUBHAM
 * Given a binary tree, return the level of the tree with minimum sum.
 */
public class P117_MinimumTreeSum 
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
        
        System.out.println(getMin(root1));
        System.out.println(getMin(root2));
    }
    private static int getMin(Node root)
    {
        Map<Node, Integer> levelMap = deep(root, new HashMap<>(), 0);
        Map<Node, Integer> sumMap = new HashMap<>();
        levelMap.entrySet().forEach(t->{
            sumMap.put(t.getKey(), getSum(t.getKey()));
            sum = 0;
        });
        Node min = sumMap.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        return levelMap.get(min);
    }
    static int sum = 0;
    private static int getSum(Node root)
    {
        sum += root.data;
        if (root.left != null) {
            getSum(root.left);
        }
        if (root.right != null) {
            getSum(root.right);
        }
        return sum;
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