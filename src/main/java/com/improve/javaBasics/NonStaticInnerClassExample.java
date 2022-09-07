package com.improve.javaBasics;

public class NonStaticInnerClassExample {
    private static int outerStaticMember = 1;

    public static int outerStaticMethod() {
        return 2;
    }

    private int outerNonStaticMember = 3;

    private int outerNonStaticMethod() {
        return 4;
    }

    class NonStaticInnerClass {
//        public static int innerStaticMember;

        public int innerNonStaticMember = outerStaticMember;

        public int innerNonStaticMember1 = outerNonStaticMember;

        public int innerNonStaticMethod() {
            outerStaticMethod();
            return outerNonStaticMethod();
        }
    }
}
