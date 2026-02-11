package com.company;

public class BonusData {
    private double baseSalary;
    private int yearsWorked;
    private double performanceScore;
    private String department;
    private boolean isManager;
    private int projectsCompleted;
    private double customerSatisfaction;
    private boolean hasTeamLeadRole;
    private int trainingSessions;

    public BonusData(double baseSalary, int yearsWorked, double performanceScore,
                     String department, boolean isManager, int projectsCompleted,
                     double customerSatisfaction, boolean hasTeamLeadRole,
                     int trainingSessions) {
        this.baseSalary = baseSalary;
        this.yearsWorked = yearsWorked;
        this.performanceScore = performanceScore;
        this.department = department;
        this.isManager = isManager;
        this.projectsCompleted = projectsCompleted;
        this.customerSatisfaction = customerSatisfaction;
        this.hasTeamLeadRole = hasTeamLeadRole;
        this.trainingSessions = trainingSessions;
    }

    public double getBaseSalary() { return baseSalary; }
    public int getYearsWorked() { return yearsWorked; }
    public double getPerformanceScore() { return performanceScore; }
    public String getDepartment() { return department; }
    public boolean isManager() { return isManager; }
    public int getProjectsCompleted() { return projectsCompleted; }
    public double getCustomerSatisfaction() { return customerSatisfaction; }
    public boolean hasTeamLeadRole() { return hasTeamLeadRole; }
    public int getTrainingSessions() { return trainingSessions; }
}
