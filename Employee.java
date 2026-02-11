package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SMELL: God Object - Esta clase hace demasiadas cosas
 * SMELL: Magic Numbers - Valores hardcodeados
 * SMELL: Long Methods - Métodos muy largos
 * SMELL: Feature Envy - Usa mucho de otras clases
 */
public class Employee {
    
    // SMELL: Data Clumps - Estos datos deberían ser objetos separados
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private String position;
    private double salary;
    private double bonusPercentage;
    private int yearsWorked;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private Date hireDate;
    private Date birthDate;
    private List<String> projects;
    private double performanceScore;
    private int vacationDays;
    private boolean isActive;
    
    public Employee(String firstName, String lastName, String email, String phone, 
                   String department, String position, double salary, int yearsWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.yearsWorked = yearsWorked;
        this.projects = new ArrayList<>();
        this.bonusPercentage = 0.0;
        this.performanceScore = 0.0;
        this.vacationDays = 20;
        this.isActive = true;
    }
    
    // SMELL: Long Method - Este método hace muchas cosas
    public double calculateAnnualCompensation() {
        double baseSalary = this.salary * 12;
        
        // SMELL: Magic Number - ¿Por qué 0.05?
        double seniorityBonus = 0;
        if (yearsWorked >= 5) {
            seniorityBonus = baseSalary * 0.05;
        }
        
        // SMELL: Magic Number - ¿Por qué 0.1?
        if (yearsWorked >= 10) {
            seniorityBonus = baseSalary * 0.1;
        }
        
        // SMELL: Magic Number - ¿Por qué 0.15?
        if (yearsWorked >= 15) {
            seniorityBonus = baseSalary * 0.15;
        }
        
        // SMELL: Magic String - Hardcodeado
        double performanceBonus = 0;
        if (performanceScore > 4.0) {
            performanceBonus = baseSalary * bonusPercentage;
        }
        
        // SMELL: Magic Number - ¿Por qué 1000?
        if (department.equals("Engineering")) {
            performanceBonus += 1000;
        }
        
        // SMELL: Magic Number - ¿Por qué 500?
        if (department.equals("Sales")) {
            performanceBonus += 500;
        }
        
        // SMELL: Magic Number - ¿Por qué 300?
        if (department.equals("HR")) {
            performanceBonus += 300;
        }
        
        // SMELL: Magic Number - ¿Por qué 250?
        if (department.equals("Operations")) {
            performanceBonus += 250;
        }
        
        double totalCompensation = baseSalary + seniorityBonus + performanceBonus;
        
        return totalCompensation;
    }
    
    // SMELL: Duplicated Code - Código similar a calculateAnnualCompensation
    public double calculateMonthlyCompensation() {
        double baseSalary = this.salary;
        
        // SMELL: Exact duplicate logic
        double seniorityBonus = 0;
        if (yearsWorked >= 5) {
            seniorityBonus = baseSalary * 0.05;
        }
        if (yearsWorked >= 10) {
            seniorityBonus = baseSalary * 0.1;
        }
        if (yearsWorked >= 15) {
            seniorityBonus = baseSalary * 0.15;
        }
        
        double performanceBonus = 0;
        if (performanceScore > 4.0) {
            performanceBonus = baseSalary * bonusPercentage;
        }
        
        if (department.equals("Engineering")) {
            performanceBonus += 83.33; // SMELL: Magic Number
        }
        if (department.equals("Sales")) {
            performanceBonus += 41.67; // SMELL: Magic Number
        }
        if (department.equals("HR")) {
            performanceBonus += 25; // SMELL: Magic Number
        }
        if (department.equals("Operations")) {
            performanceBonus += 20.83; // SMELL: Magic Number
        }
        
        double totalCompensation = baseSalary + seniorityBonus + performanceBonus;
        
        return totalCompensation;
    }
    
    // SMELL: Long Parameter List
    public boolean validateEmployee(String firstName, String lastName, String email, 
                                    String phone, String department, String position, 
                                    double salary, int yearsWorked, String address, 
                                    String city, String country, String zipCode) {
        // SMELL: Long Method
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }
        if (email == null || !email.contains("@")) {
            return false;
        }
        if (phone == null || phone.length() < 10) {
            return false;
        }
        if (department == null || department.isEmpty()) {
            return false;
        }
        if (position == null || position.isEmpty()) {
            return false;
        }
        if (salary <= 0) {
            return false;
        }
        if (yearsWorked < 0) {
            return false;
        }
        if (address == null || address.isEmpty()) {
            return false;
        }
        if (city == null || city.isEmpty()) {
            return false;
        }
        if (country == null || country.isEmpty()) {
            return false;
        }
        if (zipCode == null || zipCode.isEmpty()) {
            return false;
        }
        
        // SMELL: Magic Number
        if (zipCode.length() < 5 || zipCode.length() > 10) {
            return false;
        }
        
        return true;
    }
    
    // SMELL: Dead Code - Este método nunca es llamado
    public void deprecatedCalculateTax() {
        double taxRate = 0.25; // SMELL: Magic Number
        double annualSalary = this.salary * 12;
        double tax = annualSalary * taxRate;
        System.out.println("Tax: " + tax);
    }
    
    // SMELL: Dead Code - Este método nunca es llamado
    private void unusedPrivateMethod() {
        System.out.println("This method is never called");
    }
    
    // SMELL: Comments masking poor code
    public void processPromotion() {
        // Check if employee has been here long enough
        if (yearsWorked >= 3) {
            // Increase salary by 10%
            salary = salary * 1.1; // SMELL: Magic Number
            // Increase vacation days
            vacationDays += 5; // SMELL: Magic Number
        }
    }
    
    // Getters y Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public double getBonusPercentage() { return bonusPercentage; }
    public void setBonusPercentage(double bonusPercentage) { this.bonusPercentage = bonusPercentage; }
    
    public int getYearsWorked() { return yearsWorked; }
    public void setYearsWorked(int yearsWorked) { this.yearsWorked = yearsWorked; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    
    public List<String> getProjects() { return projects; }
    public void setProjects(List<String> projects) { this.projects = projects; }
    
    public double getPerformanceScore() { return performanceScore; }
    public void setPerformanceScore(double performanceScore) { this.performanceScore = performanceScore; }
    
    public int getVacationDays() { return vacationDays; }
    public void setVacationDays(int vacationDays) { this.vacationDays = vacationDays; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}