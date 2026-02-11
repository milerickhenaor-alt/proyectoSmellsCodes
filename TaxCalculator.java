package com.company;

public class TaxCalculator {
    private static final double FEDERAL_TAX_RATE = 0.22;
    private static final double STATE_TAX_RATE = 0.05;
    private static final double SOCIAL_SECURITY_TAX_RATE = 0.062;
    private static final double MEDICARE_TAX_RATE = 0.0145;

    public double calculateTotalTaxes(double annualSalary) {
        double federalTax = annualSalary * FEDERAL_TAX_RATE;
        double stateTax = annualSalary * STATE_TAX_RATE;
        double socialSecurityTax = annualSalary * SOCIAL_SECURITY_TAX_RATE;
        double medicareTax = annualSalary * MEDICARE_TAX_RATE;

        return federalTax + stateTax + socialSecurityTax + medicareTax;
    }
}