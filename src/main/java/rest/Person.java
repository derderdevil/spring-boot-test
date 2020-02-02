package rest;

import org.springframework.stereotype.Component;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void printPersonToString(){
        System.out.println("The Person's name is " + name + " and the Person's age is " + age);
    }

    public void test(){
        System.out.println("test");
    }
}
