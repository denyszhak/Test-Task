package com.test;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    public static int count;
    private int id;
    private String name;
    private int salary;

    public Employee(String name, int salary){
        count++;
        id = count;
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSalary(){
        return salary;
    }

    public double averageMonthSalary(){
        return 0;
    }

    public String toString() {
        return getId() + ": Average monthly salary of " +
                getName() + " equals to " + averageMonthSalary();
    }
}