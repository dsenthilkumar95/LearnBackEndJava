package com.improve.javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ImmutableExample {
    private final List<CustomClass>  customClassList;

    public ImmutableExample(List<CustomClass> customClassList) {
        List<CustomClass> customClassListCons = new ArrayList<>();
        for(CustomClass customClass : customClassList) {
            customClassListCons.add(customClass.clone());
        }
        this.customClassList = Collections.unmodifiableList(customClassListCons);
    }

    public List<CustomClass> getCustomClassList() {
        List<CustomClass> customClassListOut = new ArrayList<>();
        for(CustomClass customClass : customClassList) {
            customClassListOut.add(customClass.clone());
        }
        return customClassListOut;
    }

    public static void main(String[] args) {
        CustomClass customClass = new CustomClass();
        customClass.setId(1);
        ImmutableExample immutableExample = new ImmutableExample(Arrays.asList(customClass));
        System.out.println("Id before altering -> " + immutableExample.getCustomClassList().get(0).getId());
        customClass.setId(2);
        System.out.println("Id after altering -> " + immutableExample.getCustomClassList().get(0).getId());
    }
}

class CustomClass implements Cloneable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomClass clone() {
        CustomClass customClass = new CustomClass();
        customClass.setId(this.id);
        return customClass;
    }
}