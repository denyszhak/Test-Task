package com.test;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new EmployeeHourlyWage("Den", 28));
        employees.add(new EmployeeFixPayment("AMark", 7000));
        employees.add(new EmployeeFixPayment("Dustin", 7000));
        employees.add(new EmployeeHourlyWage("Cris", 30));
        employees.add(new EmployeeFixPayment("Eduardo", 4380));
        employees.add(new EmployeeFixPayment("Mike", 15000));
        employees.add(new EmployeeHourlyWage("Taylor", 40));
        employees.add(new EmployeeHourlyWage("Cameron", 70));
        employees.add(new EmployeeFixPayment("BLinda", 7000));
        employees.add(new EmployeeHourlyWage("Sean", 15));

        sortEmployees(employees);

        // ID, name and monthly salary for all employees from collection
        for (Employee some : employees){
            System.out.println(some);
        }

        // information about first five employees from collection (problem a)
        System.out.println("problem a");
        for (int i = 0; i < 5; i++){
            System.out.println(employees.get(i));
        }

        // ID of three last employees from collection (problem b)
        System.out.println("problem b");
        for (int i = employees.size() - 1; i >= employees.size() - 3; i--){
            System.out.println("Worker number(id) " + employees.get(i).getId());
        }
    }

    // Sorting of collection of employees in descending order
    public static void sortEmployees(ArrayList<Employee> employees){
        Collections.sort(employees, new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.averageMonthSalary() > o2.averageMonthSalary()) {
                    return -1;
                }
                else if (o1.averageMonthSalary() < o2.averageMonthSalary()) {
                    return 1;
                }
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });
    }

    //  writing the collection of objects into file
    public static void writeTheCollection(ArrayList<Employee> employees, String fileName){
        File file = new File(fileName);
        FileOutputStream fOS = null;

        try {
            fOS  = new  FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.out.println("File doesn't exist. New file cannot be created.");
                return;
            }
        }

        try (ObjectOutputStream oUS = new ObjectOutputStream(fOS)) {
            for (Employee c : employees) {
                oUS.writeObject(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  reading the collection of objects from file
    public static ArrayList<Employee> readTheCollection(ArrayList<Employee> employees, String fileName){
        FileInputStream fIS = null;

        try {
            fIS  = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            return employees;
        }

        try (ObjectInputStream oIS = new ObjectInputStream(fIS)) {
            Object obj = oIS.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}