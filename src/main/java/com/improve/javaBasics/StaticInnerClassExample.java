package com.improve.javaBasics;

public class StaticInnerClassExample {
    public static int outerStaticMember = 1;

    public static int outerStaticMethod() {
        return 2;
    }

    public int outerNonStaticMember = 3;

    public int outerNonStaticMethod() {
        return 4;
    }

    static class InnerClassStatic {
        public static int innerStaticMember = outerStaticMember;

        public static int innerStaticMethod() {
            return outerStaticMethod();
        }

//        public static int innerStaticMember2 = outerNonStaticMember;
//
//        public static int innerStaticMethod2() {
//            return outerNonStaticMethod();
//        }

        public int innerNonStaticMember = outerStaticMember;

//        public int innerNonStaticMember1 = outerNonStaticMember;

        public int innerNonStaticMethod() {
//            outerNonStaticMethod();
            return outerStaticMethod();
        }
    }

    public static void main(String[] args) {
        // Static variables can be private, and they can't be accessed outside the class
         //NonStaticInnerClassExample.outerStaticMember;
    }
}
