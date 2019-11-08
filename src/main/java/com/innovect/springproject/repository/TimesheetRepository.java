package com.innovect.springproject.repository;


import com.innovect.springproject.model.Timesheet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TimesheetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Timesheet> getAll() {

        return entityManager.createQuery("SELECT E FROM Employee E", Timesheet.class).getResultList();

    }

    public void save(Timesheet timesheet) {
        entityManager.persist(timesheet);
    }

    public Timesheet getById(Integer id) {
        Timesheet timesheet = entityManager.find(Timesheet.class, id);
        if (id == null) {
            throw new EntityNotFoundException("Can't find employee id " + id);
        }
        return timesheet;
    }

    public Timesheet getByFirstName(String firstName) {
        Timesheet timesheet =
                (Timesheet) entityManager.createQuery("select s from Employee s where s.firstName=:name").setParameter(
                        "name", firstName).getSingleResult();
        return timesheet;
    }
}
