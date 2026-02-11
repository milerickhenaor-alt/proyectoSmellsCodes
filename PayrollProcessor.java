package com.company;

public class PayrollProcessor {
    
    private Database database;
    private TaxCalculator taxCalculator;
    private BenefitsCalculator benefitsCalculator;
    private CompensationCalculator compensationCalculator;
    private PayrollReport payrollReport;

    public PayrollProcessor(Database database) {
        this.database = database;
        this.taxCalculator = new TaxCalculator();
        this.benefitsCalculator = new BenefitsCalculator();
        this.compensationCalculator = new CompensationCalculator();
        this.payrollReport = new PayrollReport();
    }

    private PayrollData calculateMonthlyPayroll(Employee employee) {
        double monthlySalary = employee.getSalary();
        double annualSalary = monthlySalary * 12;

        double totalTaxes = taxCalculator.calculateTotalTaxes(annualSalary);
        double totalBenefits = benefitsCalculator.calculateTotalBenefits(annualSalary, 1);
        double bonus = compensationCalculator.calculateBonus(employee, monthlySalary);
        double commission = compensationCalculator.calculateCommission(employee, monthlySalary);

        return new PayrollData(monthlySalary, bonus, commission, totalTaxes, totalBenefits);
    }

    private PayrollData calculateAnnualPayroll(Employee employee) {
        double annualSalary = employee.getSalary() * 12;

        double totalTaxes = taxCalculator.calculateTotalTaxes(annualSalary);
        double totalBenefits = benefitsCalculator.calculateTotalBenefits(annualSalary, 12);
        double bonus = compensationCalculator.calculateBonus(employee, annualSalary);
        double commission = compensationCalculator.calculateCommission(employee, annualSalary);

        return new PayrollData(annualSalary, bonus, commission, totalTaxes, totalBenefits);
    }

    public void processPayroll() {
        for (Employee emp : database.getAllEmployees()) {
            PayrollData data = calculateMonthlyPayroll(emp);
            payrollReport.printMonthlyReport(emp, data);
        }
    }

    public void processAnnualPayroll() {
        for (Employee emp : database.getAllEmployees()) {
            PayrollData data = calculateAnnualPayroll(emp);
            payrollReport.printAnnualReport(emp, data);
        }
    }
}