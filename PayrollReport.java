package com.company;

public class PayrollReport {

    public void printMonthlyReport(Employee employee, PayrollData data) {
        System.out.println("Employee: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Monthly Salary: $" + data.getSalary());
        System.out.println("Bonus: $" + data.getBonus());
        System.out.println("Commission: $" + data.getCommission());
        System.out.println("Total Taxes: $" + data.getTotalTaxes());
        System.out.println("Total Benefits: $" + data.getTotalBenefits());
        System.out.println("Net Pay: $" + data.getNetPay());
        System.out.println("---");
    }

    public void printAnnualReport(Employee employee, PayrollData data) {
        System.out.println("Employee: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Annual Salary: $" + data.getSalary());
        System.out.println("Bonus: $" + data.getBonus());
        System.out.println("Commission: $" + data.getCommission());
        System.out.println("Total Taxes: $" + data.getTotalTaxes());
        System.out.println("Total Benefits: $" + data.getTotalBenefits());
        System.out.println("Annual Net Pay: $" + data.getNetPay());
        System.out.println("---");
    }
}