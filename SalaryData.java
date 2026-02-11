package com.company;

public class SalaryData {
    private double monthlySalary;
    private int yearsWorked;
    private double performanceScore;
    private String department;
    private int projectsCompleted;

    public SalaryData(double monthlySalary, int yearsWorked,
                      double performanceScore, String department,
                      int projectsCompleted) {
        this.monthlySalary = monthlySalary;
        this.yearsWorked = yearsWorked;
        this.performanceScore = performanceScore;
        this.department = department;
        this.projectsCompleted = projectsCompleted;
    }

    public double getMonthlySalary() { return monthlySalary; }
    public int getYearsWorked() { return yearsWorked; }
    public double getPerformanceScore() { return performanceScore; }
    public String getDepartment() { return department; }
    public int getProjectsCompleted() { return projectsCompleted; }
}
