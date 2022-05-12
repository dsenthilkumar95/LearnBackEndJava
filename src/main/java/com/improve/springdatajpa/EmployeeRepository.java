package com.improve.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Iterable<Employee> findByDobGreaterThan(Date inDate);

}
