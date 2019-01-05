/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Google
 * @author SHUBHAM
 * Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.
 */
public class P78_MergeLinkedList 
{
    static class Node
    {
        int data;
        Node next;
        
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        
        public void push(int new_data) 
        { 
            Node new_node = new Node(new_data); 
            new_node.next = next; 
            next = new_node; 
        } 
    }
    
    public static void main(String[] args) 
    {
        Node a;
        a = new Node(1); 
        a.next = new Node(3); 
        a.next.next = new Node(5); 
        a.next.next.next = new Node(7);
        
        Node b;
        b = new Node(2); 
        b.next = new Node(4); 
        b.next.next = new Node(6); 
        b.next.next.next = new Node(8);
        
        Node c;
        c = new Node(0); 
        c.next = new Node(9); 
        c.next.next = new Node(10); 
        c.next.next.next = new Node(11);
//        c.push(9);
//        c.push(10);
//        c.push(11);
        List<Node> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        int k = 3;
        
        P78_MergeLinkedList list = new P78_MergeLinkedList();
        Node z = list.SimpleMerge(nodes, k);
        list.print(z);
    }
    
    private Node SimpleMerge(List<Node> nodes, int k)
    {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < k; i++) 
        {
            Node n = nodes.get(i);
            while(n!=null)
            {
                l.add(n.data);
                n = n.next;
            }
        }
        Collections.sort(l);
        Node merged = new Node(l.get(l.size()-1));
        
        for (int i = 0; i < l.size()-1; i++) 
        {
            merged.push(l.get(i));
        }
        return merged;
    }
    
    private void print(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("");
    }
}
