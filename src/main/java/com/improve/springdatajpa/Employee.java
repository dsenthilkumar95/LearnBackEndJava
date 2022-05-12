package com.improve.springdatajpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="employee")
@Data
public class Employee implements Serializable {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private Date dob;
    @Column
    private Date employmentdate;
    @Column
    private Float salary;
    @Column
    private String role;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", employmentDate=" + employmentdate +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                '}';
    }
}
