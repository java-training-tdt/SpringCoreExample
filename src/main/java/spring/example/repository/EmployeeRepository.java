package spring.example.repository;

import spring.example.Entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployee();

    int getMaxEmployeeNumber();

    Employee getEmployeeByEmployeeNumber(int employeeNumber);
    Employee findEmployeeByEmployeeNumber(int employeeNumber);

    void addEmployee(Employee employee);
    void addEmployeeUsingPersist(Employee employee);
}
