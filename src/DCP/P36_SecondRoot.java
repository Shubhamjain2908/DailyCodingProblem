/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import Tree.Tree;

/**
 * Dropbox
 * @author SHUBHAM
   Given the root to a binary search tree, find the second largest node in the tree.
 */
public class P36_SecondRoot {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(15);
        intTree.insert(22);
        intTree.insert(6);
        intTree.insert(92);
        intTree.insert(21);
        intTree.insert(64);
        intTree.insert(1);
        
        System.out.println(secondRoot(intTree));
    }
    public static int secondRoot(Tree root) 
    {
        int max = root.max();
        root.delete(max);
        return root.max();
    }
}
