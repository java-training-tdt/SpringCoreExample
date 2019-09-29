package spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import spring.example.Entity.Employee;
import spring.example.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getAllEmployee() {

        List<Employee> employeeList = employeeService.getAllEmployee();

        if (CollectionUtils.isEmpty(employeeList)) {
            return "An Error has occurred";
        }

        return employeeList.stream().map(Employee::toString).collect(Collectors.joining("<br>"));
    }

    @GetMapping("/max")
    public String getMaxId() {

        return "Max Employee Number is: " + employeeService.getMaxEmployeeNumber();
    }

    @GetMapping("/employee")
    public String getEmployeeDetail(@RequestParam(name = "employeeNumber") int employeeNumber) {

        Employee employee = employeeService.getEmployeeByEmployeeNumber(employeeNumber);

        if (employee == null) {
            return "An Error has occurred";
        }
        return employee.toString();
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeRequestBody employeeRequestBody) {

        // Request body json
        /*{
            "employeeNumber": 1,
            "lastName": "Chris",
            "firstName": "Bebe",
            "extension": "x5800",
            "email": "email.@mail.com",
            "officeCode": "1",
            "reportsTo": 1143,
            "jobTitle": "CEO"
        }*/

        // Check validate employeeRequestBody before insert
        // Be sure the new employeeNumber is not exists in database
        // ...

        // Factory EmployeeRequestBody -> Employee
        Employee employee = new Employee(
                employeeRequestBody.getEmployeeNumber(),
                employeeRequestBody.getLastName(),
                employeeRequestBody.getFirstName(),
                employeeRequestBody.getExtension(),
                employeeRequestBody.getEmail(),
                employeeRequestBody.getOfficeCode(),
                employeeRequestBody.getReportsTo(),
                employeeRequestBody.getJobTitle());

        employeeService.addEmployee(employee);

        return "ADD SUCCESS!!! " + "Status: 200";
    }
}
