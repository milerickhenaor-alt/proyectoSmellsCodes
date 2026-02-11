package com.company;

import java.util.List;

public class Report {
    
    private List<Employee> employees;
    private Database database;
    
    // Constantes para eliminar "Magic Numbers" y facilitar mantenimiento REFAC 3 
    private static final double BONUS_LEVEL_1 = 0.05;
    private static final double BONUS_LEVEL_2 = 0.10;
    private static final double BONUS_LEVEL_3 = 0.15;
    
    private static final int YEARS_THRESHOLD_1 = 5;
    private static final int YEARS_THRESHOLD_2 = 10;
    private static final int YEARS_THRESHOLD_3 = 15;

    public Report(List<Employee> employees, Database database) {
        this.employees = employees;
        this.database = database;
    }

    /**
     * REFACTOR: Se eliminó el "Long Method" extrayendo la lógica de cálculo 
     * e impresión a métodos especializados.
     */
    public void generateSalaryReport() {
        System.out.println("=== SALARY REPORT ===");
        for (Employee emp : employees) {
            double baseSalary = emp.getSalary() * 12;
            double seniorityBonus = calculateSeniorityBonus(emp, baseSalary);
            double performanceBonus = calculatePerformanceBonus(emp, baseSalary);
            double totalCompensation = baseSalary + seniorityBonus + performanceBonus;
            
            printSalaryDetails(emp, baseSalary, seniorityBonus, performanceBonus, totalCompensation);
        }
    }

    /**
     * REFACTOR: Se redujo la complejidad del método extrayendo la lógica 
     * de determinación de estatus.
     */
    public void generatePerformanceReport() {
        System.out.println("=== PERFORMANCE REPORT ===");
        for (Employee emp : employees) {
            double rating = emp.getPerformanceScore();
            String status = determinePerformanceStatus(rating);
            
            printPerformanceDetails(emp, rating, status);
        }
    }

    /**
     * REFACTOR: Se eliminó el "Duplicated Code" reutilizando los métodos 
     * de cálculo centralizados.
     */
    public void generateBonusReport() {
        System.out.println("=== BONUS REPORT ===");
        for (Employee emp : employees) {
            double baseSalary = emp.getSalary() * 12;
            double seniorityBonus = calculateSeniorityBonus(emp, baseSalary);
            double performanceBonus = calculatePerformanceBonus(emp, baseSalary);
            double totalBonus = seniorityBonus + performanceBonus;
            
            printBonusDetails(emp, seniorityBonus, performanceBonus, totalBonus);
        }
    }

    /**
     * REFACTOR: Se mantiene la funcionalidad delegando correctamente 
     * la persistencia a la base de datos.
     */
    public void saveReportToDatabase() {
        for (Employee emp : employees) {
            database.saveEmployee(emp);
        }
    }

    // --- MÉTODOS PRIVADOS EXTRAÍDOS (Lógica de Negocio Centralizada) ---

    private double calculateSeniorityBonus(Employee emp, double baseSalary) {
        int years = emp.getYearsWorked();
        if (years >= YEARS_THRESHOLD_3) return baseSalary * BONUS_LEVEL_3;
        if (years >= YEARS_THRESHOLD_2) return baseSalary * BONUS_LEVEL_2;
        if (years >= YEARS_THRESHOLD_1) return baseSalary * BONUS_LEVEL_1;
        return 0;
    }

    private double calculatePerformanceBonus(Employee emp, double baseSalary) {
        double bonus = 0;
        if (emp.getPerformanceScore() > 4.0) {
            bonus = baseSalary * emp.getBonusPercentage();
        }
        
        // Uso de switch para mejorar la legibilidad de departamentos
        switch (emp.getDepartment()) {
            case "Engineering": bonus += 1000; break;
            case "Sales":       bonus += 500;  break;
            case "HR":          bonus += 300;  break;
            case "Operations":  bonus += 250;  break;
        }
        return bonus;
    }

    private String determinePerformanceStatus(double rating) {
        if (rating >= 4.5) return "Excellent";
        if (rating >= 4.0) return "Good";
        if (rating >= 3.0) return "Average";
        if (rating >= 2.0) return "Below Average";
        return "Poor";
    }

    // --- MÉTODOS DE IMPRESIÓN (Limpieza de Reportes) ---

    private void printSalaryDetails(Employee emp, double base, double sen, double perf, double total) {
        System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Base Salary: $" + base);
        System.out.println("Seniority Bonus: $" + sen);
        System.out.println("Performance Bonus: $" + perf);
        System.out.println("Total Compensation: $" + total);
        System.out.println("---");
    }

    private void printPerformanceDetails(Employee emp, double rating, String status) {
        System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
        System.out.println("Performance Score: " + rating);
        System.out.println("Status: " + status);
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Years Worked: " + emp.getYearsWorked());
        System.out.println("---");
    }

    private void printBonusDetails(Employee emp, double sen, double perf, double total) {
        System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
        System.out.println("Seniority Bonus: $" + sen);
        System.out.println("Performance Bonus: $" + perf);
        System.out.println("Total Bonus: $" + total);
        System.out.println("---");
    }
}
