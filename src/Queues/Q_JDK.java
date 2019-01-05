/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author SHUBHAM
 */
public class Q_JDK 
{
    public static void main(String[] args) 
    {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            q.offer(i+5);
        }
        q.add(21);
        q.offer(Integer.SIZE);
        q.remove();
        q.remove();
        q.remove();
        System.out.println(q.peek());
        System.out.println(q.element());
        System.out.println(q.poll());
        
        System.out.println(q.element());
        //q.forEach(System.out::println);
    }
}
