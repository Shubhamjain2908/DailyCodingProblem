/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author SHUBHAM
 */
public class EmployeeNode {
    
    private Employee employee;
    private EmployeeNode next;
    
    public EmployeeNode(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }
    
    @Override
    public String toString()
    {
        return employee.toString();
    }
    
}
