package com.onlyone.algorithm.singlelink;

public class Entity {

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;


    public void add() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "( name = " + name + "  age = " + age + ")";
    }
}
