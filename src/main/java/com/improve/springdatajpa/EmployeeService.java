package com.improve.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {}

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
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
}
