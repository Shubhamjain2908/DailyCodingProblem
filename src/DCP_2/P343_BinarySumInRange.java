/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Google
 *
 * @author SHUBHAM Given a binary search tree and a range [a, b] (inclusive),
 * return the sum of the elements of the binary search tree within the range.
 * For example, given the following tree: 
 *  5
   / \
  3   8
 / \ / \
2  4 6  10
 * and the range [4, 9], return 23 (5 + 4 + 6 + 8).
 */
public class P343_BinarySumInRange {
    
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        int min = 4;
        int max = 9;
        System.out.println("Sum => " + getSum(root, min, max));
    }

    /**
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static int getSum(Node root, int min, int max) {
        return traverse(root, min, max, 0);
    }
    
    private static int traverse(Node root, int min, int max, int sum) {
        int data = root.data;
        if (data >= min && data <= max) {
            sum += data;
        }
        if (root.left != null) {
            sum = traverse(root.left, min, max, sum);
        }
        if (root.right != null) {
            sum = traverse(root.right, min, max, sum);
        }
        return sum;
    }
    
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }
}
