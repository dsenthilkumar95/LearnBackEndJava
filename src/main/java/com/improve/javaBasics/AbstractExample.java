package com.improve.javaBasics;

public class AbstractExample {
    public static void abstractAcceptor(AbstractClass abstractClass) {
        System.out.println("Calling getId method -> " + abstractClass.getId());
    }
    public static void main(String[] args) {
        AbstractImpl anAbstract = new AbstractImpl();
        AbstractExample.abstractAcceptor(anAbstract);
    }
}

abstract class AbstractClass {
    public abstract int getId();
}

class AbstractImpl extends AbstractClass {

    @Override
    public int getId() {
        return 1;
    }
}