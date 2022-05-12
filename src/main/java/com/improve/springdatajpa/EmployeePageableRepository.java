package com.improve.springdatajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageableRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findById(long id, Pageable pageable);
}
