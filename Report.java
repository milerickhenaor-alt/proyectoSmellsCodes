package com.company;

import java.util.List;

/**
 * SMELL: Duplicated Code - Código similar a Employee
 * SMELL: Long Methods
 * SMELL: Feature Envy - Usa mucho de Employee
 */
public class Report {
    
    private List<Employee> employees;
    private Database database;
    
    public Report(List<Employee> employees, Database database) {
        this.employees = employees;
        this.database = database;
    }
    
    // SMELL: Long Method - Demasiado largo
    // SMELL: Duplicated Code - Similar a calculateAnnualCompensation en Employee
    public void generateSalaryReport() {
        System.out.println("=== SALARY REPORT ===");
        
        for (Employee emp : employees) {
            double baseSalary = emp.getSalary() * 12;
            
            // SMELL: Magic Numbers (duplicados)
            double seniorityBonus = 0;
            if (emp.getYearsWorked() >= 5) {
                seniorityBonus = baseSalary * 0.05;
            }
            if (emp.getYearsWorked() >= 10) {
                seniorityBonus = baseSalary * 0.1;
            }
            if (emp.getYearsWorked() >= 15) {
                seniorityBonus = baseSalary * 0.15;
            }
            
            double performanceBonus = 0;
            if (emp.getPerformanceScore() > 4.0) {
                performanceBonus = baseSalary * emp.getBonusPercentage();
            }
            
            // SMELL: Magic Numbers (duplicados)
            if (emp.getDepartment().equals("Engineering")) {
                performanceBonus += 1000;
            }
            if (emp.getDepartment().equals("Sales")) {
                performanceBonus += 500;
            }
            if (emp.getDepartment().equals("HR")) {
                performanceBonus += 300;
            }
            if (emp.getDepartment().equals("Operations")) {
                performanceBonus += 250;
            }
            
            double totalCompensation = baseSalary + seniorityBonus + performanceBonus;
            
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Base Salary: $" + baseSalary);
            System.out.println("Seniority Bonus: $" + seniorityBonus);
            System.out.println("Performance Bonus: $" + performanceBonus);
            System.out.println("Total Compensation: $" + totalCompensation);
            System.out.println("---");
        }
    }
    
    // SMELL: Long Method
    public void generatePerformanceReport() {
        System.out.println("=== PERFORMANCE REPORT ===");
        
        for (Employee emp : employees) {
            // SMELL: Magic Number
            double rating = emp.getPerformanceScore();
            String status = "";
            
            // SMELL: Magic Numbers
            if (rating >= 4.5) {
                status = "Excellent";
            } else if (rating >= 4.0) {
                status = "Good";
            } else if (rating >= 3.0) {
                status = "Average";
            } else if (rating >= 2.0) {
                status = "Below Average";
            } else {
                status = "Poor";
            }
            
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Performance Score: " + rating);
            System.out.println("Status: " + status);
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Years Worked: " + emp.getYearsWorked());
            System.out.println("---");
        }
    }
    
    // SMELL: Duplicated Code - Similar a generateSalaryReport
    public void generateBonusReport() {
        System.out.println("=== BONUS REPORT ===");
        
        for (Employee emp : employees) {
            double baseSalary = emp.getSalary() * 12;
            
            // SMELL: Exact duplicate logic
            double seniorityBonus = 0;
            if (emp.getYearsWorked() >= 5) {
                seniorityBonus = baseSalary * 0.05;
            }
            if (emp.getYearsWorked() >= 10) {
                seniorityBonus = baseSalary * 0.1;
            }
            if (emp.getYearsWorked() >= 15) {
                seniorityBonus = baseSalary * 0.15;
            }
            
            double performanceBonus = 0;
            if (emp.getPerformanceScore() > 4.0) {
                performanceBonus = baseSalary * emp.getBonusPercentage();
            }
            
            if (emp.getDepartment().equals("Engineering")) {
                performanceBonus += 1000;
            }
            if (emp.getDepartment().equals("Sales")) {
                performanceBonus += 500;
            }
            if (emp.getDepartment().equals("HR")) {
                performanceBonus += 300;
            }
            if (emp.getDepartment().equals("Operations")) {
                performanceBonus += 250;
            }
            
            double totalBonus = seniorityBonus + performanceBonus;
            
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Seniority Bonus: $" + seniorityBonus);
            System.out.println("Performance Bonus: $" + performanceBonus);
            System.out.println("Total Bonus: $" + totalBonus);
            System.out.println("---");
        }
    }
    
    // SMELL: Feature Envy - Accede mucho a database
    public void saveReportToDatabase() {
        for (Employee emp : employees) {
            database.saveEmployee(emp);
        }
    }
}