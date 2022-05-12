package com.improve.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/getEmployeesGreaterThan",produces = "application/json",consumes = "application/json")
    public List<Employee> getEmployeesGreaterThan(@RequestParam Map<String,String> params) {
        return employeeService.dobGreaterThan(params.get("date"));
    }

    @GetMapping(path = "/getAllEmployeesWithPagination",produces = "application/json",consumes = "application/json")
    public List<Employee> getAllEmployeesWithPagination(@RequestParam Map<String,String> params) {
        int page = Integer.valueOf(params.get("page"));
        int size = Integer.valueOf(params.get("size"));
        String direction = params.get("direction");
        String props = params.get("properties");
        String[] propsArray = props.split(",");
        return employeeService.getByPageNumber(page,size,direction,propsArray);
    }
}
