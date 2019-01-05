/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.Collections;
import java.util.Stack;

/**
 * Apple
 * @author SHUBHAM
 * Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.
 */
public class P53_QueueUsingStack 
{
    public static void main(String[] args) 
    {
        DCP53_Q q = new DCP53_Q();
        q.enqueue(12);
        q.enqueue(22);
        q.enqueue(23);
        q.enqueue(82);
        q.printQueue();
        q.dequeue();
        System.out.println("Q");
        q.printQueue();
    }
}
class DCP53_Q
{
    private final Stack<Integer> st1;
    private final Stack<Integer> st2;
    
    public DCP53_Q()
    {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void enqueue(int x)
    {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    public int dequeue()
    {
        if(st1.isEmpty()){
            return 0;
        }
        return st1.pop();
    }
    
    public void printQueue(){
        if (st1.isEmpty()) {
            System.out.println("Queue is empty");
        }
        Stack<Integer> st3 = new Stack<>();
        st3.addAll(st1);
        Collections.reverse(st3);
        st3.forEach(System.out::println);
    }
}
