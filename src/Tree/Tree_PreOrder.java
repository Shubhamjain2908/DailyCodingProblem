/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author SHUBHAM
 */
public class Tree_PreOrder 
{
    public static void main(String[] args) 
    {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        
        System.out.print("In order : ");
        intTree.traverseInOrder();
        System.out.println("");
        
        System.out.print("Pre order : ");
        intTree.traversePreOrder();
        System.out.println("");
        
        System.out.print("Post order : ");
        intTree.traversePostOrder();
        
        System.out.println();
    }
    
}
