package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CLASS EMPLOYEE - SOFIA RUBIO CASTAÑEDA
 *
 * Code smells corregidos:
 *
 * 1. Magic Numbers:
 *    Se reemplazaron valores numéricos hardcodeados por constantes descriptivas.
 *
 * 2. Long Methods:
 *    Se dividieron métodos largos en métodos más pequeños
 *    aplicando Separation of Concerns.
 *
 * 3. Feature Envy:
 *    Se aplicó el patrón Strategy usando un enum Department
 *    para delegar la lógica de cálculo de bonos.
 */

public class Employee {

    // =====================================================
    // 1️⃣ MAGIC NUMBERS → Reemplazados por constantes
    // =====================================================

    private static final double SENIORITY_5_YEARS = 0.05;
    private static final double SENIORITY_10_YEARS = 0.10;
    private static final double SENIORITY_15_YEARS = 0.15;

    private static final double PROMOTION_INCREASE_PERCENTAGE = 0.10;
    private static final int PROMOTION_EXTRA_VACATION_DAYS = 5;

    private static final double PERFORMANCE_THRESHOLD = 4.0;

    private static final int DEFAULT_VACATION_DAYS = 20;

    private static final int MIN_ZIP_LENGTH = 5;
    private static final int MAX_ZIP_LENGTH = 10;

    // =====================================================
    // 3️⃣ FEATURE ENVY → Patrón Strategy con enum interno
    // Cada departamento ahora maneja su propio bono
    // =====================================================

    public enum Department {
        ENGINEERING(1000),
        SALES(500),
        HR(300),
        OPERATIONS(250);

        private final double annualBonus;

        Department(double annualBonus) {
            this.annualBonus = annualBonus;
        }

        public double getAnnualBonus() {
            return annualBonus;
        }

        public double getMonthlyBonus() {
            return annualBonus / 12;
        }
    }

    // =====================================================
    // ATRIBUTOS
    // =====================================================

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Department department; // Ahora es enum (ya no String)
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

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public Employee(String firstName, String lastName, String email, String phone,
                    Department department, String position,
                    double salary, int yearsWorked) {

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
        this.vacationDays = DEFAULT_VACATION_DAYS;
        this.isActive = true;
    }

    // =====================================================
    // 2️⃣ LONG METHOD → Dividido en métodos pequeños
    // Separation of Concerns
    // =====================================================

    public double calculateAnnualCompensation() {

        double baseSalary = calculateAnnualBaseSalary();
        double seniorityBonus = calculateSeniorityBonus(baseSalary);
        double performanceBonus = calculateAnnualPerformanceBonus(baseSalary);

        return baseSalary + seniorityBonus + performanceBonus;
    }

    public double calculateMonthlyCompensation() {

        double baseSalary = salary;
        double seniorityBonus = calculateSeniorityBonus(baseSalary);
        double performanceBonus = calculateMonthlyPerformanceBonus(baseSalary);

        return baseSalary + seniorityBonus + performanceBonus;
    }

    // =====================================================
    // Métodos extraídos (antes estaban dentro del método largo)
    // =====================================================

    private double calculateAnnualBaseSalary() {
        return salary * 12;
    }

    private double calculateSeniorityBonus(double baseSalary) {

        if (yearsWorked >= 15) return baseSalary * SENIORITY_15_YEARS;
        if (yearsWorked >= 10) return baseSalary * SENIORITY_10_YEARS;
        if (yearsWorked >= 5) return baseSalary * SENIORITY_5_YEARS;

        return 0;
    }

    private double calculateAnnualPerformanceBonus(double baseSalary) {

        double bonus = 0;

        if (performanceScore > PERFORMANCE_THRESHOLD) {
            bonus += baseSalary * bonusPercentage;
        }

        // Delegación al Department (Strategy)
        bonus += department.getAnnualBonus();

        return bonus;
    }

    private double calculateMonthlyPerformanceBonus(double baseSalary) {

        double bonus = 0;

        if (performanceScore > PERFORMANCE_THRESHOLD) {
            bonus += baseSalary * bonusPercentage;
        }

        bonus += department.getMonthlyBonus();

        return bonus;
    }

    // =====================================================
    // VALIDACIÓN (mejor organizada)
    // =====================================================

    public boolean validateEmployee() {

        return isNotEmpty(firstName)
                && isNotEmpty(lastName)
                && isValidEmail(email)
                && isValidPhone(phone)
                && department != null
                && isNotEmpty(position)
                && salary > 0
                && yearsWorked >= 0
                && isNotEmpty(address)
                && isNotEmpty(city)
                && isNotEmpty(country)
                && isValidZipCode(zipCode);
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.length() >= 10;
    }

    private boolean isValidZipCode(String zipCode) {
        return zipCode != null &&
                zipCode.length() >= MIN_ZIP_LENGTH &&
                zipCode.length() <= MAX_ZIP_LENGTH;
    }

    // =====================================================
    // PROMOCIÓN (sin números mágicos)
    // =====================================================

    public void processPromotion() {

        if (yearsWorked >= 3) {

            // Uso de constantes en lugar de 1.1 y 5
            salary = salary * (1 + PROMOTION_INCREASE_PERCENTAGE);
            vacationDays += PROMOTION_EXTRA_VACATION_DAYS;
        }
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

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
