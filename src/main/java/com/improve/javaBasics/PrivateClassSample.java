package com.improve.javaBasics;

public class PrivateClassSample {
    public InterfaceForPrivateClass getNewPrivateGuy() {
        return new PrivateGuy();
    }
    private class PrivateGuy implements InterfaceForPrivateClass {

        @Override
        public int count() {
            return 9;
        }
    }

    public static void main(String[] args) {
        PrivateClassSample privateClassSample = new PrivateClassSample();
        InterfaceForPrivateClass interfaceForPrivateClass = privateClassSample.getNewPrivateGuy();
        // This is possible only inside the same class. See class PrivateClassUser
        PrivateGuy privateGuy = (PrivateGuy) interfaceForPrivateClass;
        System.out.println(privateGuy.count());
    }
}
