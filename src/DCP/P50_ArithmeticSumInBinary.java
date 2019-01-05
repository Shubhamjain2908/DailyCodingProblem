/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;

/**
 * Microsoft
 * @author SHUBHAM
 *  Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
    Given the root to such a tree, write a function to evaluate it.
    For example, given the following tree:
        *
       / \
      +    +
     / \  / \
    3  2  4  5

    You should return 45, as it is (3 + 2) * (4 + 5).
 */
public class P50_ArithmeticSumInBinary 
{
    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) 
    {
        DCP50_NodeP d = new DCP50_NodeP("*");
        d.left = new DCP50_NodeP("+");
        d.left.left = new DCP50_NodeP("3");
        d.left.right = new DCP50_NodeP("2");
        d.right = new DCP50_NodeP("+");
        d.right.left = new DCP50_NodeP("4");
        d.right.right = new DCP50_NodeP("5");
        
        System.out.println(getSum(d));
    }
    private static int getSum(DCP50_NodeP d)
    {
        getTree(d);
//        list.forEach(System.out::print);
//        System.out.println("");
        Object middle = d.data;
        List<Object> left = new ArrayList<>();
        List<Object> right = new ArrayList<>();
        boolean middleFound = false;
        int midIndex = list.size()/2;
        for (int i = 0; i < list.size(); i++) 
        {
            if (i == midIndex) {
                middleFound = true;
            }
            if (!middleFound && i!=midIndex) {
                left.add(list.get(i));
            }
            if (middleFound && i!=midIndex) {
                right.add(list.get(i));
            }
        }
        int a = computeExp(left);
        int b = computeExp(right);
        return getValue(a, b, String.valueOf(middle));
    }
    private static int computeExp(List<Object> list)
    {
        if (list.size() == 3) {
            return getValue(Integer.valueOf(String.valueOf(list.get(0))),Integer.valueOf(String.valueOf(list.get(2))), String.valueOf(list.get(1)));
        }
        return 0;
    }
    private static int getValue(int a, int b, String exp){
        if (null != exp) switch (exp) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                break;
        }
        return 0;
    }
    private static void getTree(DCP50_NodeP root)
    {
        if (root.left != null) {
            getTree(root.left);
        }
        list.add(root.data);
        if (root.right != null) {
            getTree(root.right);
        }
    }
}
class DCP50_NodeP
{
    Object data;
    DCP50_NodeP right, left;
    DCP50_NodeP(Object data){
        this.data = data;
    }
}