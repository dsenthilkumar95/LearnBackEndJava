package com.improve.springdatajpa;

import javax.persistence.*;

@Entity
@Table(name = "userwithcompkey")
@IdClass(UserWithCompositeKeyId.class)
public class UserWithCompositeKey {
    @Id
    private String firstname;
    @Id
    private String secondname;
    @Column
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserWithCompositeKey{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
