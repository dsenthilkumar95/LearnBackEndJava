package com.improve.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeePageableRepository employeePageableRepository;

    public EmployeeService() {}

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeePageableRepository employeePageableRepository){
        this.employeeRepository = employeeRepository;
        this.employeePageableRepository = employeePageableRepository;
    }

    public List<Employee> dobGreaterThan(String date) {
        Date inDate = null;
        try {
            inDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Iterable<Employee> byDobGreaterThan = employeeRepository.findByDobGreaterThan(inDate);
        List<Employee> out = new ArrayList<>();
        byDobGreaterThan.iterator().forEachRemaining(emp -> {System.out.println(emp);
        out.add(emp);});
        return out;
    }

    public List<Employee> getByPageNumber(int page, int size, String direction, String... properties) {
        Sort.Direction directionEnum;
        if(direction.equals("desc")) {
            directionEnum = Sort.Direction.DESC;
        } else {
            directionEnum = Sort.Direction.ASC;
        }
        PageRequest pageRequest = PageRequest.of(page,size,directionEnum,properties);
        Pageable pageable = pageRequest;
        Page<Employee> empPage = employeePageableRepository.findAll(pageRequest);
        List<Employee> employeeList = new ArrayList<>();
        empPage.iterator().forEachRemaining(emp -> employeeList.add(emp));
        return employeeList;
    }
}
