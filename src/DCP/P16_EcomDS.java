/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Stack;

/**
 * Twitter
 * @author SHUBHAM
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
    You should be as efficient with time and space as possible.
 */
public class P16_EcomDS 
{
    public static void main(String[] args) 
    {
        EcomDS e = new EcomDS();
        for (int i = 0; i < 100; i++) {
            e.record(i);
        }
        e.print();
        System.out.println(e.get_last(40));
    }
}
class EcomDS
{
    private final Stack<Integer> st;
    
    public EcomDS()
    {
        st = new Stack<>();
    }
    
    public void record(int x)
    {
        st.push(x);
    }
    
    public int get_last(int index)
    {
        Stack<Integer> st2 = new Stack<>();
        st2.addAll(st);
        for (int i = 0; i < index-1; i++) 
        {
            st2.pop();
        }
        return st2.peek();
    }
    
    public void print()
    {
        st.forEach(t->System.out.print(t + " "));
        System.out.println("");
    }
}
