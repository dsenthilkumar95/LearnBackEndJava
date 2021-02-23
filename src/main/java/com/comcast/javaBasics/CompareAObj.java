package com.comcast.javaBasics;

public class CompareAObj implements Comparable<CompareAObj> {
    private int id;
    private String name;

    @Override
    public int compareTo(CompareAObj o) {
        return this.id - o.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompareAObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
