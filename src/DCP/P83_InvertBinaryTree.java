/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  Google
 *  @author SHUBHAM
 *  Invert a binary tree.
    For example, given the following tree:
        a
       / \
      b   c
     / \  /
    d   e f

    should become:
      a
     / \
     c  b
     \  / \
      f e  d
 */
public class P83_InvertBinaryTree 
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
        Node root = new Node("a"); 
        root.left = new Node("b"); 
        root.right = new Node("c"); 
        root.left.left = new Node("d");
        root.left.right = new Node("e");
        root.right.left = new Node("f"); 
        
        Node root2 = new Node("a");
        root2.right = new Node("c");
        root2.left = new Node("b");
        root2.left.left = new Node("d");
        
        Node root3 = new Node("a"); 
        root3.left = new Node("c"); 
        root3.right = new Node("b");  
        root3.left.right = new Node("f");
        root3.right.left = new Node("e"); 
        root3.right.right = new Node("d");  
        
//        invertTree(root);

        Node e = mirror(root);
        traverseLevelOrder(e, new LinkedList<>()).forEach(t->System.out.print(t.data + " "));
        System.out.println("");
        
        Node e2 = mirror(root2);
        traverseLevelOrder(e2, new LinkedList<>()).forEach(t->System.out.print(t.data + " "));
        System.out.println("");
        
        Node e3 = mirror(root3);
        traverseLevelOrder(e3, new LinkedList<>()).forEach(t->System.out.print(t.data + " "));
    }
    private static Node mirror(Node root)
    {
        if (root == null) 
           return root; 
         
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    private static Node invertTree(Node root)
    {
        Invert i = new Invert(0,"root");
        Map<Node, Invert> map = new HashMap<>();
        Map<Node, Invert> m = deep(root, map, i);
        Map<Integer, List<Node>> le = new HashMap<>();
        m.entrySet().forEach(e -> {
            Invert s = e.getValue();
            if ("right".equals(s.child)) {
                s.child = "left";
            }
            else if ("left".equals(s.child)) {
                s.child = "right";
            }
        });
        m.entrySet().forEach(e -> System.out.println(e.getKey().data + " -> " + e.getValue()));
        m.entrySet().forEach(e -> {
            Invert s = e.getValue();
            List<Node> l = new ArrayList<>();
            if (le.containsKey(s.level)) {
                l.addAll(le.get(s.level));
            }
            l.add(e.getKey());
            le.put(s.level, l);
        });
        
        List<Integer> size = new ArrayList<>();
        le.entrySet().forEach(e -> {
            size.add(e.getValue().size());
        });
        Deque<Node> q = traverseLevelOrder(root, new LinkedList<>());
        Deque<Node> r = new LinkedList<>();
        List<String[]> si = new ArrayList<>();
        for (int j = 0; j < size.size(); j++) 
        {
            int n = size.get(j);
            String[] s = new String[n];
            for (int k = 0; k < n; k++) 
            {
                s[k] = q.remove().data;
            }
            si.add(s);
        }
        si.forEach(d -> System.err.println(Arrays.toString(d)));
//        q.forEach(e -> System.err.print(e.data + " "));
        return root;
    }
    
    private static Map<Node, Invert> deep(Node root, Map<Node, Invert> map, Invert i)
    {
        map.put(root, i);
        if (root.left != null) {
            Invert l = new Invert(i.level + 1,"left");
            deep(root.left, map, l);
        }
        if (root.right != null) {
            Invert r = new Invert(i.level + 1,"right");
            deep(root.right, map, r);
        }
        return map;
    }
    
    private static Deque<Node> traverseLevelOrder(Node root, Deque<Node> q)
    {
        if (root != null) {
            q.add(root);
            if (root.left != null) {
                traverseLevelOrder(root.left, q);
            }
            if (root.right != null) {
                traverseLevelOrder(root.right, q);
            }
        }
        return q;
    }
}
class Invert
{
    int level;
    String child;

    public Invert(int level, String child) {
        this.level = level;
        this.child = child;
    }
    
    @Override
    public String toString() {
        return "Invert{" + "level=" + level + ", child=" + child + '}';
    }
    
}
