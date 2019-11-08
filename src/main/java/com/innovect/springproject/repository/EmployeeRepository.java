package com.innovect.springproject.repository;

import com.innovect.springproject.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getAll() {

        return entityManager.createQuery("SELECT E FROM Employee E", Employee.class).getResultList();

    }

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee getById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (id == null) {
            throw new EntityNotFoundException("Can't find employee id " + id);
        }
        return employee;
    }

    public Employee getByFirstName(String firstName) {
        Employee employee =
                (Employee) entityManager.createQuery("select s from Employee s where s.firstName=:name").setParameter("name", firstName).getSingleResult();
        return employee;
    }
}
