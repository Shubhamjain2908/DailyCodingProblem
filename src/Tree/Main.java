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
public class Main {
    
    public static void main(String[] args) {
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
         
        intTree.traverseInOrder();
        System.out.println(" ");
        intTree.delete(15);
        
        intTree.traverseInOrder();
//        System.out.println("");
//        System.out.println(intTree.get(25));
//        System.out.println(intTree.get(252));
//        System.out.println(intTree.max());
    }
    
}
