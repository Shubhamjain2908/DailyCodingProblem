/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author SHUBHAM
 */
public class Stacks {
    
    public static void main(String[] args) {
        
        ArrayStack stack = new ArrayStack(10);
        stack.push(new Employee("RR", "Martin", 1));
        stack.push(new Employee("Emilia", "Clark", 2));
        stack.push(new Employee("Kit", "Harington", 3));
        stack.push(new Employee("Peter", "Dinklage", 4));
    
        stack.printStack();
        
        System.out.println(stack.peek());
        
        stack.pop();
        
        stack.push(new Employee("Sophie", "Turner", 5));
        
        stack.printStack();
    }
    
}
