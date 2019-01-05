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
public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public void insert(int value){
        if (value == data) {
            return;
        }
        
        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            }
            else{
                leftChild.insert(value);
            }
        }
        else{
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            }
            else{
                rightChild.insert(value);
            }
        }
    }
    
    public TreeNode get(int value){
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        }
        else{
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        
        return null;
    }

    
    public int min(){
        if (leftChild == null) {
            return data;
        }
        return leftChild.min();
    }
    
    public int max(){
        if (rightChild == null) {
            return data;
        }
        return rightChild.max();
    }
    
    public void traverseInOrder(){
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print( data + ", ");
        if (rightChild!=null) {
            rightChild.traverseInOrder();
        }
    }
    
    public void traversePreOrder(){
        System.out.print(data + ", ");
        if (leftChild != null) {
            leftChild.traversePreOrder();
        }
        if (rightChild != null) {
            rightChild.traversePreOrder();
        }
    }
    
    public void traversePostOrder(){
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (rightChild != null) {
            rightChild.traversePostOrder();
        }
        System.out.print(data + ", ");
    }
    
    public TreeNode(int data){
        this.data = data;
    }
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return leftChild;
    }

    public void setLeft(TreeNode left) {
        this.leftChild = left;
    }

    public TreeNode getRight() {
        return rightChild;
    }

    public void setRight(TreeNode right) {
        this.rightChild = right;
    }
    
    @Override
    public String toString() {
        return "TreeNode{" + "data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + '}';
    }
    
}
