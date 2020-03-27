package com.example.mylianxi;

public class Person {
    String name;
    public Person() {
        // TODO Auto-generated constructor stub
    }
    public Person(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }


}
