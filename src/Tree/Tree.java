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
public class Tree {
    
    private TreeNode root;
    
    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else{
            root.insert(value);
        }
    }
    
    public TreeNode get(int value){
        if (root != null) {
            return root.get(value);
        }
        return null;
    }
    
    public void delete(int value){
        root = delete(root, value);
    }
    
    private TreeNode delete(TreeNode subTreeRoot, int value){
        if (subTreeRoot == null) {
            return null;
        }
        
        if (value < subTreeRoot.getData()) {
            subTreeRoot.setLeft(delete(subTreeRoot.getLeft(), value));
        }
        else if(value > subTreeRoot.getData()){
            subTreeRoot.setRight(delete(subTreeRoot.getRight(), value));
        }
        else{
            // Case 1 and 2: node to delete has 0 or 1 children
            if (subTreeRoot.getLeft() == null) {
                return subTreeRoot.getRight();
            }
            else if (subTreeRoot.getRight() == null) {
                return subTreeRoot.getLeft();
            }
            
            // Case 3: node to delete has 2 children
            
            //Replace the value in the subTree node with the smallest value from the right subtree
            subTreeRoot.setData(subTreeRoot.getRight().min());
            
            // Delete the node that has the smallest value in right subtree
            subTreeRoot.setRight(delete(subTreeRoot.getRight(), subTreeRoot.getData()));
        }
        return subTreeRoot;
    }
    
    public int min(){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.min();
    }
    
    public int max(){
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return root.max();
    }
    
    public void traverseInOrder(){
        if (root!=null) {
            root.traverseInOrder();
        }
    }
    
    public void traversePreOrder(){
        if (root!=null) {
            root.traversePreOrder();
        }
    }
    
    public void traversePostOrder(){
        if (root!=null) {
            root.traversePostOrder();
        }
    }
}
