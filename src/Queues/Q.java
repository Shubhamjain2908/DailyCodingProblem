/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author SHUBHAM
 */
public class Q {
    
    public static void main(String[] args) {
        
        Employee george = new Employee("RR", "Martin", 1); 
        Employee dany = new Employee("Emilia", "Clark", 2);
        Employee jon = new Employee("Kit", "Harington", 3);
        Employee tyrion = new Employee("Peter", "Dinklage", 4);
        Employee sansa = new Employee("Sophie","Turner",5);
        
        ArrayQueue queue = new ArrayQueue(10);
        
        queue.add(george);
        queue.add(dany);
        queue.add(jon);
        queue.add(tyrion);
        queue.add(sansa);
        
        queue.remove();
        queue.remove();
        queue.printQueue();
    }
    
}
