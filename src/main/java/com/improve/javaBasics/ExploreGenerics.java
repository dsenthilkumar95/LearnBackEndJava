package com.improve.javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ExploreGenerics {
    public void lowerBoundWildCard() {
        List<? super Derived> lowerFixedList = Arrays.asList(new Derived(), new Base());
        for(Object o : lowerFixedList) {
            System.out.println(o.getClass());
        }
        List<? super Derived> lowerList = new ArrayList<>();
        lowerList.add(new Derived());
//        lowerList.add(new Base());
        lowerList.add(null);
    }

    public void unboundWildCard() {
        List<?> unboundFixedList = Arrays.asList(new Base(1), new Derived(2));
        for(Object o : unboundFixedList) {
            System.out.println(o.getClass());
        }
        boolean contains = unboundFixedList.contains(new Base(1));
        System.out.println("contains -> "+contains);
        List<?> unboundList = new ArrayList<>();
//        unboundList.add(new Base(1));
        unboundList.add(null);
    }

    public void upperBoundWildcard() {
        List<? extends Base> upperList = new ArrayList<>();
//        not possible since upperList type is capture of <? extends Base>
//        upperList.add(new Base());
//        upperList.add(new Derived());
        upperList.add(null);
        List<? extends Base> upperFixedList = Arrays.asList(new Base(1), new Derived(2));
        for(Base base : upperFixedList) {
            System.out.println(base.getBaseId());
            System.out.println(base.getClass());
        }
        System.out.println(upperFixedList.getClass());
    }

    private Double add(ArrayList<? extends Number> num) {
        double sum=0.0;
        for(Number n:num)
        {
            sum = sum+n.doubleValue();
        }
        return sum;
    }

    public void useAdd() {
        ArrayList<Integer> l1=new ArrayList<Integer>();
        l1.add(10);
        l1.add(20);
        System.out.println("displaying the sum= "+add(l1));

        ArrayList<Double> l2=new ArrayList<Double>();
        l2.add(30.0);
        l2.add(40.0);
        System.out.println("displaying the sum= "+add(l2));
    }

    public static void main(String[] args) {
        ExploreGenerics exploreGenerics = new ExploreGenerics();
//        exploreGenerics.upperBoundWildcard();
//        exploreGenerics.useAdd();
        exploreGenerics.unboundWildCard();
    }
}

class Base {
    public Base(){}
    public Base(int id){this.baseId = id;}
    private int baseId;

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return baseId == base.baseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseId);
    }
}

class Derived extends Base{
    public Derived(){}
    public Derived(int id){setBaseId(id);}
    private int derivedId;

    public int getDerivedId() {
        return derivedId;
    }

    public void setDerivedId(int derivedId) {
        this.derivedId = derivedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Derived derived = (Derived) o;
        return derivedId == derived.derivedId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), derivedId);
    }
}
