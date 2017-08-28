package com.test;

public class EmployeeHourlyWage extends Employee{
    public EmployeeHourlyWage(String name, int salary) {
        super(name, salary);
    }

    public double averageMonthSalary() {
        return 20.8 * 8 * getSalary();
    }
}
