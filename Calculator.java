package com.company;

public class Calculator {

    // ===============================
    // CONSTANTES (elimina Magic Numbers)
    // ===============================

    private static final double BASE_BONUS_RATE = 0.10;

    private static final double BONUS_5_YEARS = 0.05;
    private static final double BONUS_10_YEARS = 0.08;
    private static final double BONUS_15_YEARS = 0.12;

    private static final double PERFORMANCE_HIGH = 0.15;
    private static final double PERFORMANCE_MEDIUM = 0.10;
    private static final double PERFORMANCE_LOW = 0.05;

    private static final double ENGINEERING_MULTIPLIER = 1.20;
    private static final double SALES_MULTIPLIER = 1.15;
    private static final double HR_MULTIPLIER = 0.95;

    private static final double MANAGER_BONUS = 0.20;
    private static final double PROJECTS_HIGH = 0.10;
    private static final double PROJECTS_MEDIUM = 0.05;
    private static final double CUSTOMER_SATISFACTION_BONUS = 0.08;
    private static final double TEAM_LEAD_BONUS = 0.15;
    private static final double TRAINING_BONUS = 0.05;

    private static final double BASE_TAX_RATE = 0.25;
    private static final double SENIORITY_TAX_DISCOUNT = 0.02;
    private static final double HIGH_SALARY_TAX_INCREASE = 0.05;
    private static final double EXECUTIVE_TAX_INCREASE = 0.10;


    // Refactorización: Replace Magic Number with Named Constant:

    public double calculateComplexBonus(BonusData data) {

        double bonus = data.getBaseSalary() * BASE_BONUS_RATE;

        if (data.getYearsWorked() >= 5) {
            bonus += data.getBaseSalary() * BONUS_5_YEARS;
        }

        if (data.getYearsWorked() >= 10) {
            bonus += data.getBaseSalary() * BONUS_10_YEARS;
        }

        if (data.getYearsWorked() >= 15) {
            bonus += data.getBaseSalary() * BONUS_15_YEARS;
        }

        if (data.getPerformanceScore() > 4.5) {
            bonus += data.getBaseSalary() * PERFORMANCE_HIGH;
        } else if (data.getPerformanceScore() > 4.0) {
            bonus += data.getBaseSalary() * PERFORMANCE_MEDIUM;
        } else if (data.getPerformanceScore() > 3.0) {
            bonus += data.getBaseSalary() * PERFORMANCE_LOW;
        }

        switch (data.getDepartment()) {
            case "Engineering":
                bonus *= ENGINEERING_MULTIPLIER;
                break;
            case "Sales":
                bonus *= SALES_MULTIPLIER;
                break;
            case "HR":
                bonus *= HR_MULTIPLIER;
                break;
        }

        if (data.isManager()) {
            bonus += data.getBaseSalary() * MANAGER_BONUS;
        }

        if (data.getProjectsCompleted() >= 10) {
            bonus += data.getBaseSalary() * PROJECTS_HIGH;
        } else if (data.getProjectsCompleted() >= 5) {
            bonus += data.getBaseSalary() * PROJECTS_MEDIUM;
        }

        if (data.getCustomerSatisfaction() > 4.5) {
            bonus += data.getBaseSalary() * CUSTOMER_SATISFACTION_BONUS;
        }

        if (data.hasTeamLeadRole()) {
            bonus += data.getBaseSalary() * TEAM_LEAD_BONUS;
        }

        if (data.getTrainingSessions() >= 10) {
            bonus += data.getBaseSalary() * TRAINING_BONUS;
        }

        return bonus;
    }

    // ===============================
    // TAX
    // ===============================

    public double calculateTaxAmount(double salary, int yearsWorked, String department) {

        double taxRate = BASE_TAX_RATE;

        if (yearsWorked >= 10) {
            taxRate -= SENIORITY_TAX_DISCOUNT;
        }

        if (salary > 100000) {
            taxRate += HIGH_SALARY_TAX_INCREASE;
        }

        if ("Executive".equals(department)) {
            taxRate += EXECUTIVE_TAX_INCREASE;
        }

        return salary * taxRate;
    }

    // ===============================
    // FINAL SALARY (DESACOPLADO)
    // ===============================

    public double calculateFinalSalary(SalaryData data) {

        double baseSalary = data.getMonthlySalary() * 12;

        BonusData bonusData = new BonusData(
                data.getMonthlySalary(),
                data.getYearsWorked(),
                data.getPerformanceScore(),
                data.getDepartment(),
                false,
                0,
                0,
                false,
                0
        );

        double bonus = calculateComplexBonus(bonusData);

        double tax = calculateTaxAmount(
                baseSalary,
                data.getYearsWorked(),
                data.getDepartment()
        );

        return baseSalary + bonus - tax;
    }
}
