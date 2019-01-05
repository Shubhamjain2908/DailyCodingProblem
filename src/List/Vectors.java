/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author SHUBHAM
 */
public class Vectors {
    // Thread safe implementation of List
    public static void main(String[] args) {
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("RR", "Martin", 1));
        employeeList.add(new Employee("Emilia", "Clark", 2));
        employeeList.add(new Employee("Kit", "Harington", 3));
        employeeList.add(new Employee("Peter", "Dinklage", 4));
    }
}
