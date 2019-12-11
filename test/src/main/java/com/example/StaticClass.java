package com.example;

/**
 * Copyright (C) 2018, PING AN TECHNOLOGIES CO., LTD.
 * StaticClass
 * <p>
 * Description
 *
 * @author MaShiZhao
 * @version 1.0
 * <p>
 * Ver 1.0, 2019-11-22, MaShiZhao, Create file
 */
public class StaticClass {


    private int age = 1;
    private String name = "msz";
    private static int ageStatic = 1;

    public static void getAge(){

    }

    public static class InnerStaticClass {

        private static int ageInnerStatic = 1;

        public int getAge() {
            return ageStatic;
        }
    }

    public class InnerClass {

        private int number = 1;

        public int getAge() {
            return age;
        }
    }
}
