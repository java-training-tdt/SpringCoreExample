package spring.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import spring.example.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> getAllEmployee() {

        try {
            String sql = "FROM Employee";
            Query query = entityManager.createQuery(sql);

            return query.getResultList();

        } catch (DataAccessException ex) {
            return null;
        }
    }

    public int getMaxEmployeeNumber() {

        try {
            String sql = "SELECT coalesce(max(e.id), 0) FROM Employee e";
            Query query = entityManager.createQuery(sql);

            return (int)query.getSingleResult();

        } catch (DataAccessException ex) {
            return 0;
        }
    }

    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {

        try {
            String sql = "FROM Employee e WHERE e.employeeNumber = :employeeNumber";
            Query query = entityManager.createQuery(sql);
            query.setParameter("employeeNumber", employeeNumber);

            return (Employee)query.getSingleResult();

        } catch (DataAccessException ex) {
            return null;
        }
    }

    /**
     * Another way to get by Id
     * find(): Cannot find the employee -> return null
     * getReference(): Cannot get the employee -> return empty object
     */
    public Employee findEmployeeByEmployeeNumber(int employeeNumber) {

        try {
            // return entityManager.getReference(Employee.class, employeeNumber);
            return entityManager.find(Employee.class, employeeNumber);

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Transactional
    public void addEmployee(Employee employee) {

        try {
            String sql = "INSERT INTO `employee` (`employee_number`, `last_name`, `first_name`, `extension`, `email`, `office_code`, `reports_to`, `job_title`) " +
                    "VALUES (:employeeNumber, :lastName, :firstName, :extension, :email, :officeCode, :reportsTo, :jobTitle)";

            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("employeeNumber", employee.getEmployeeNumber());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("extension", employee.getExtension());
            query.setParameter("email", employee.getEmail());
            query.setParameter("officeCode", employee.getOfficeCode());
            query.setParameter("reportsTo", employee.getReportsTo());
            query.setParameter("jobTitle", employee.getJobTitle());

            query.executeUpdate();

        } catch (DataAccessException ex) {
            // throw custom exception if has
        }
    }

    /**
     * Another way to insert
     */
    public void addEmployeeUsingPersist(Employee employee) {

        try {
            entityManager.persist(employee);

        } catch (DataAccessException ex) {
            // throw custom exception if has
        }
    }
}
