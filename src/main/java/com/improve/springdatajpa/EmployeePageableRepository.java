package com.improve.springdatajpa;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageableRepository extends PagingAndSortingRepository<Employee, Long> {
}
