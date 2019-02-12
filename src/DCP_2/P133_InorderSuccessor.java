/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Amazon
 * @author SHUBHAM
 * Given a node in a binary tree, return the next bigger element, also known as the inorder successor.
    For example, the inorder successor of 22 is 30.
       10
      /  \
     5    30
         /  \
       22    35
    You can assume each node has a parent pointer.

 */
public class P133_InorderSuccessor 
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
        root.right = new Node(30);
        root.right.left = new Node(22);
        root.right.right = new Node(35);
        getTree(root);
        Node l = root.right.left;
        System.out.println(getSuccessor(l));
    }
    private static int getSuccessor(Node node) 
    {
        int[] index = {0};
        map.entrySet().forEach(e -> {
            if (e.getValue() == node) {
                index[0] = e.getKey();
            }
        });
        return map.get(index[0]+1).data;
    }
    static Map<Integer, Node> map = new HashMap<>();
    static int i = 1;
    private static void getTree(Node root)
    {
        if (root.left != null) {
            getTree(root.left);
        }
        map.put(i, root);
        i++;
        if (root.right != null) {
            getTree(root.right);
        }
    }
}
