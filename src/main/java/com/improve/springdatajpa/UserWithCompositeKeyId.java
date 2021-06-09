package com.improve.springdatajpa;

import java.io.Serializable;
import java.util.Objects;

public class UserWithCompositeKeyId implements Serializable {
    private String firstname;
    private String secondname;

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

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        UserWithCompositeKeyId userWithCompositeKeyId = (UserWithCompositeKeyId) o;
        return firstname.equals(userWithCompositeKeyId.getFirstname()) && secondname.equals(userWithCompositeKeyId.getSecondname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, secondname);
    }

    @Override
    public String toString() {
        return "UserWithCompositeKeyId{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                '}';
    }
}
