package com.company;

public class PayrollData {
    private final double salary;
    private final double bonus;
    private final double commission;
    private final double totalTaxes;
    private final double totalBenefits;
    private final double netPay;

    public PayrollData(double salary, double bonus, double commission,
                       double totalTaxes, double totalBenefits) {
        this.salary = salary;
        this.bonus = bonus;
        this.commission = commission;
        this.totalTaxes = totalTaxes;
        this.totalBenefits = totalBenefits;
        this.netPay = salary + bonus + commission - totalTaxes - totalBenefits;
    }

    public double getSalary() { return salary; }
    public double getBonus() { return bonus; }
    public double getCommission() { return commission; }
    public double getTotalTaxes() { return totalTaxes; }
    public double getTotalBenefits() { return totalBenefits; }
    public double getNetPay() { return netPay; }
}