/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Microsoft
 * @author SHUBHAM
 * Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.
    For example, the following linked list:
    1 -> 2 -> 3 -> 4 -> 5
    is the number 54321.
    Given two linked lists in this format, return their sum in the same linked list format.
    For example, given
    9 -> 9
    5 -> 2
    return 124 (99 + 25) as:
    4 -> 2 -> 1
 */
public class P127_SumReverseLinkedList 
{
    public static void main(String[] args) 
    {
        LinkedList l1 = new LinkedList();
        l1.insert(9);
        l1.insert(9);
        
        
        LinkedList l2 = new LinkedList();
        l2.insert(5);
        l2.insert(2);
        
        getReversedLinkedList(l1, l2).printList();
    }
    private static LinkedList getReversedLinkedList(LinkedList l1, LinkedList l2)
    {
        List<Integer> list = l1.getList();
        Collections.reverse(list);
        StringBuilder s1 = new StringBuilder();
        list.forEach(t-> {
            s1.append(t);
        });
        
        List<Integer> list2 = l2.getList();
        Collections.reverse(list2);
        StringBuilder s2 = new StringBuilder();
        list2.forEach(t-> {
            s2.append(t);
        });
        
        String x = String.valueOf(Integer.valueOf(s1.toString()) + Integer.valueOf(s2.toString()));
        
        LinkedList l3 = new LinkedList();
        for (int i = x.length()-1; i >= 0; i--) {
            int c = Integer.valueOf(String.valueOf(x.charAt(i)));
            l3.insert(c);
        }
        return l3;
    }
}
class LinkedList 
{
    Node head; // head of list 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    public void insert(int data) 
    { 
        Node new_node = new Node(data); 

        if (head == null) { 
            head = new_node; 
        } 
        else { 
            Node last = head; 
            while (last.next != null) { 
                last = last.next; 
            } 
            last.next = new_node; 
        } 
    } 
    
    public void printList() 
    { 
        Node currNode = head; 
        System.out.print("LinkedList: "); 
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        }
        System.out.println("");
    } 
    
    public List<Integer> getList(){
        List<Integer> al = new ArrayList<>();
        Node currNode = head; 
        while (currNode != null) { 
            al.add(currNode.data);
            currNode = currNode.next; 
        }
        return al;
    }
}