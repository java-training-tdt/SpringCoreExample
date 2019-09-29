package spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.example.Entity.Employee;
import spring.example.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {

        return employeeRepository.getAllEmployee();
    }

    public int getMaxEmployeeNumber() {

        return employeeRepository.getMaxEmployeeNumber();
    }

    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {

        return employeeRepository.getEmployeeByEmployeeNumber(employeeNumber);
    }

    public void addEmployee(Employee employee) {

        employeeRepository.addEmployee(employee);
    }
}
