package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class - Punto de entrada de la aplicación
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");

        // Crear base de datos
        Database database = new Database();

        // Crear empleados
        Employee emp1 = new Employee("Juan", "García", "juan@company.com", "555-0001",
                "Engineering", "Senior Developer", 5000, 8);
        emp1.setBonusPercentage(0.15);
        emp1.setPerformanceScore(4.5);

        Employee emp2 = new Employee("María", "López", "maria@company.com", "555-0002",
                "Sales", "Sales Manager", 4500, 12);
        emp2.setBonusPercentage(0.20);
        emp2.setPerformanceScore(4.2);

        Employee emp3 = new Employee("Carlos", "Rodríguez", "carlos@company.com", "555-0003",
                "HR", "HR Specialist", 3500, 5);
        emp3.setBonusPercentage(0.10);
        emp3.setPerformanceScore(3.8);

        Employee emp4 = new Employee("Ana", "Martínez", "ana@company.com", "555-0004",
                "Operations", "Operations Manager", 4000, 6);
        emp4.setBonusPercentage(0.12);
        emp4.setPerformanceScore(4.1);

        // Guardar en base de datos
        database.saveEmployee(emp1);
        database.saveEmployee(emp2);
        database.saveEmployee(emp3);
        database.saveEmployee(emp4);

        // Crear lista para reportes
        List<Employee> employees = database.getAllEmployees();

        // Generar reportes
        Report report = new Report(employees, database);

        System.out.println("\n");
        report.generateSalaryReport();

        System.out.println("\n");
        report.generatePerformanceReport();

        System.out.println("\n");
        report.generateBonusReport();

        // Usar Calculator
        System.out.println("\n=== INDIVIDUAL CALCULATIONS ===\n");
        Calculator calc = new Calculator();

        for (Employee emp : employees) {

            SalaryData salaryData = new SalaryData(
                    emp.getSalary(),
                    emp.getYearsWorked(),
                    emp.getPerformanceScore(),
                    emp.getDepartment(),
                    emp.getProjects().size()
            );

            double finalSalary = calc.calculateFinalSalary(salaryData);

            System.out.println(emp.getFirstName() + " " + emp.getLastName() +
                    " - Final Salary: $" + String.format("%.2f", finalSalary));
        }

        // Mostrar todos los empleados
        System.out.println("\n=== ALL EMPLOYEES ===\n");
        database.printAllEmployees();

        // Mostrar cálculo de compensación anual
        System.out.println("\n=== ANNUAL COMPENSATION ===\n");
        for (Employee emp : employees) {
            double annualComp = emp.calculateAnnualCompensation();
            System.out.println(emp.getFirstName() + " " + emp.getLastName() +
                    " - Annual Compensation: $" + String.format("%.2f", annualComp));
        }
    }
}