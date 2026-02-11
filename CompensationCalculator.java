package com.company;

public class CompensationCalculator {
    private static final double PERFORMANCE_THRESHOLD = 4.0;
    private static final double SALES_COMMISSION_RATE = 0.15;

    public double calculateBonus(Employee employee, double salary) {
        if (employee.getPerformanceScore() > PERFORMANCE_THRESHOLD) {
            return salary * employee.getBonusPercentage();
        }
        return 0;
    }

    public double calculateCommission(Employee employee, double salary) {
        if ("Sales".equals(employee.getDepartment())) {
            return salary * SALES_COMMISSION_RATE;
        }
        return 0;
    }
}