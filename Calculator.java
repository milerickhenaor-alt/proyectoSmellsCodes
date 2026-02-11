package com.company;

/**
 * SMELL: Data Clumps - Parámetros relacionados que deberían ser objetos
 * SMELL: Long Parameter Lists
 * SMELL: Magic Numbers
 */
public class Calculator {
    
    // SMELL: Long Parameter List - 9 parámetros
    public double calculateComplexBonus(double baseSalary, int yearsWorked, 
                                        double performanceScore, String department, 
                                        boolean isManager, int projectsCompleted,
                                        double customerSatisfaction, boolean hasTeamLeadRole,
                                        int trainingSessions) {
        
        // SMELL: Magic Numbers everywhere
        double bonus = baseSalary * 0.1;
        
        if (yearsWorked >= 5) {
            bonus += baseSalary * 0.05;
        }
        
        if (yearsWorked >= 10) {
            bonus += baseSalary * 0.08;
        }
        
        if (yearsWorked >= 15) {
            bonus += baseSalary * 0.12;
        }
        
        if (performanceScore > 4.5) {
            bonus += baseSalary * 0.15;
        } else if (performanceScore > 4.0) {
            bonus += baseSalary * 0.10;
        } else if (performanceScore > 3.0) {
            bonus += baseSalary * 0.05;
        }
        
        if (department.equals("Engineering")) {
            bonus *= 1.2; // Magic Number
        } else if (department.equals("Sales")) {
            bonus *= 1.15; // Magic Number
        } else if (department.equals("HR")) {
            bonus *= 0.95; // Magic Number
        }
        
        if (isManager) {
            bonus += baseSalary * 0.2; // Magic Number
        }
        
        if (projectsCompleted >= 10) {
            bonus += baseSalary * 0.1; // Magic Number
        } else if (projectsCompleted >= 5) {
            bonus += baseSalary * 0.05; // Magic Number
        }
        
        if (customerSatisfaction > 4.5) {
            bonus += baseSalary * 0.08; // Magic Number
        }
        
        if (hasTeamLeadRole) {
            bonus += baseSalary * 0.15; // Magic Number
        }
        
        if (trainingSessions >= 10) {
            bonus += baseSalary * 0.05; // Magic Number
        }
        
        return bonus;
    }
    
    // SMELL: Long Parameter List
    public double calculateTaxAmount(double salary, int yearsWorked, String department,
                                     double performanceScore, boolean isManager,
                                     String country, String state) {
        // SMELL: Magic Numbers
        double taxRate = 0.25;
        
        if (yearsWorked >= 10) {
            taxRate -= 0.02; // Magic Number
        }
        
        if (salary > 100000) {
            taxRate += 0.05; // Magic Number
        }
        
        if (department.equals("Executive")) {
            taxRate += 0.10; // Magic Number
        }
        
        double tax = salary * taxRate;
        return tax;
    }
    
    // SMELL: Tight Coupling - Usa directamente de Employee
    public double calculateFinalSalary(Employee employee) {
        double baseSalary = employee.getSalary() * 12;
        double bonus = calculateComplexBonus(
            employee.getSalary(),
            employee.getYearsWorked(),
            employee.getPerformanceScore(),
            employee.getDepartment(),
            false,
            employee.getProjects().size(),
            0,
            false,
            0
        );
        
        double tax = calculateTaxAmount(
            baseSalary,
            employee.getYearsWorked(),
            employee.getDepartment(),
            employee.getPerformanceScore(),
            false,
            "USA",
            ""
        );
        
        return baseSalary + bonus - tax;
    }
}