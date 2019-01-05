/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class ArrayList1 {
    
    public static void main(String[] args) {
    
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("RR", "Martin", 1));
        employeeList.add(new Employee("Emilia", "Clark", 2));
        employeeList.add(new Employee("Kit", "Harington", 3));
        employeeList.add(new Employee("Peter", "Dinklage", 4));
        
        employeeList.add(1, new Employee("Lena", "Hedely", 11));
        employeeList.forEach(el -> System.out.println(el));
    }
    
}
