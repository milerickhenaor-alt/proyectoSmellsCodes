package com.company;

public class BenefitsCalculator {
    private static final double MONTHLY_HEALTH_INSURANCE = 500;
    private static final double MONTHLY_DENTAL_INSURANCE = 50;
    private static final double MONTHLY_VISION_INSURANCE = 25;
    private static final double MONTHLY_LIFE_INSURANCE = 100;
    private static final double RETIREMENT_401K_RATE = 0.06;

    public double calculateTotalBenefits(double annualSalary, int months) {
        double healthInsurance = MONTHLY_HEALTH_INSURANCE * months;
        double dentalInsurance = MONTHLY_DENTAL_INSURANCE * months;
        double visionInsurance = MONTHLY_VISION_INSURANCE * months;
        double lifeInsurance = MONTHLY_LIFE_INSURANCE * months;
        double retirement401k = annualSalary * RETIREMENT_401K_RATE;

        return healthInsurance + dentalInsurance + visionInsurance +
                lifeInsurance + retirement401k;
    }
}