package com.company;

/**
 * SMELL: Inappropriate Intimacy
 * - Accede directamente a atributos privados de otras clases
 * - Manipula internals de Employee
 * 
 * SMELL: Switch Statements
 * - Largos switch statements que deberían ser polymorphism
 */
public class SalesManager {
    
    // SMELL: Inappropriate Intimacy - acceso directo a internals
    public void manageSalesEmployee(Employee emp) {
        // Manipular directamente sin respetar encapsulación
        emp.setSalary(emp.getSalary() * 1.2);
        emp.setBonusPercentage(emp.getBonusPercentage() + 0.1);
        emp.setVacationDays(emp.getVacationDays() - 3);
    }
    
    // SMELL: Switch Statement - debería ser Strategy/Polymorphism
    public double calculateCommission(String employeeType, double salesAmount) {
        double commission = 0;
        
        switch(employeeType) {
            case "JUNIOR_SALES":
                commission = salesAmount * 0.05;
                break;
            case "SENIOR_SALES":
                commission = salesAmount * 0.10;
                break;
            case "SALES_MANAGER":
                commission = salesAmount * 0.15;
                break;
            case "REGIONAL_MANAGER":
                commission = salesAmount * 0.20;
                break;
            case "VICE_PRESIDENT":
                commission = salesAmount * 0.25;
                break;
            case "EXECUTIVE":
                commission = salesAmount * 0.30;
                break;
            default:
                commission = salesAmount * 0.02;
        }
        
        return commission;
    }
}