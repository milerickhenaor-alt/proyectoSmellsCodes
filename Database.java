package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Tight Coupling - Muy acoplado a Employee
 * SMELL: Data Class - Solo getters/setters
 */
public class Database {

    private List<Employee> employees = new ArrayList<>();

    // SMELL: No hay validación real
    public void saveEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
            // SMELL: Magic String hardcodeado
            System.out.println("Employee saved to database");
        }
    }

    // SMELL: Long Method
    public Employee getEmployeeById(String id) {
        for (Employee emp : employees) {
            if ((emp.getFirstName() + emp.getLastName()).equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // SMELL: Duplicated Code - Similar a getEmployeeById
    public Employee getEmployeeByEmail(String email) {
        for (Employee emp : employees) {
            if (emp.getEmail().equals(email)) {
                return emp;
            }
        }
        return null;
    }

    // SMELL: Duplicated Code - Similar a getEmployeeById
    public Employee getEmployeeByPhone(String phone) {
        for (Employee emp : employees) {
            if (emp.getPhone().equals(phone)) {
                return emp;
            }
        }
        return null;
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // SMELL: Magic String
    public void printAllEmployees() {
        for (Employee emp : employees) {
            System.out.println("ID: " + (emp.getFirstName() + emp.getLastName()));
            System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Email: " + emp.getEmail());
            System.out.println("Phone: " + emp.getPhone());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("---");
        }
    }
}