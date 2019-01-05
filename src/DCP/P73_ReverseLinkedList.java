/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Google
 * @author SHUBHAM
 * Given the head of a singly linked list, reverse it in-place.
 */
public class P73_ReverseLinkedList 
{
    static Node head; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
    
    private Node reverseList(Node head)
    {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    
    private void printList(Node node) 
    { 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println("");
    } 
    
    public static void main(String[] args) 
    {
        P73_ReverseLinkedList list = new P73_ReverseLinkedList();
        list.head = new Node(85); 
        list.head.next = new Node(15); 
        list.head.next.next = new Node(4); 
        list.head.next.next.next = new Node(20); 
        head = list.reverseList(head);
        list.printList(head);
    }
}