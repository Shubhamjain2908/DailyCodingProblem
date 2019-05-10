/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Morgan Stanley
 * @author SHUBHAM
 * In Ancient Greece, it was common to write text with the first line going left to right, the second line going right to left, and continuing to go back and forth. This style was called "boustrophedon".
    Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
    For example, given the following tree:
           1
        /     \
      2         3
     / \       / \
    4   5     6   7
    You should return [1, 3, 2, 4, 5, 6, 7].

 */
public class P258_BoustrophedonOrder {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        System.out.println(getBoustrophedon(tree));
    }
    
    public static List<Integer> getBoustrophedon(Node root) {
        List<Integer> al = new ArrayList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        map = deep(root, map, 0);
        map.entrySet().forEach(e -> {
            int key = e.getKey();
            List<Node> l = e.getValue();
            if (key %2 == 0) {
                Collections.reverse(l);
            }
            al.addAll(l.stream().map(s -> s.data).collect(Collectors.toList()));
        });
        return al;
    }
    private static Map<Integer, List<Node>> deep(Node root, Map<Integer, List<Node>> map, int level)
    {
        List<Node> l = new ArrayList<>();
        l.add(root);
        if (map.containsKey(level)) {
            l.addAll(map.get(level));
            map.put(level, l);
        }
        map.put(level, l);
        if (root.left != null) {
            deep(root.left, map, level+1);
        }
        if (root.right != null) {
            deep(root.right, map, level+1);
        }
        return map;
    }
}
