package com.company;

/**
 * SMELL: Divergent Change
 * - La clase cambia por múltiples razones
 * - Cambios en cálculo de salarios, impuestos, beneficios afectan esta clase
 * 
 * SMELL: Shotgun Surgery
 * - Un cambio pequeño requiere modificaciones en múltiples lugares
 * - Si cambia la estructura de Employee, hay que cambiar aquí
 */
public class PayrollProcessor {
    
    private Database database;
    
    public PayrollProcessor(Database database) {
        this.database = database;
    }
    
    // SMELL: Shotgun Surgery - Cambiar estructura de Employee requiere cambios aquí
    // SMELL: Divergent Change - Cambios en salarios, impuestos, beneficios
    public void processPayroll() {
        for (Employee emp : database.getAllEmployees()) {
            // Cálculo de salario
            double monthlySalary = emp.getSalary();
            double annualSalary = monthlySalary * 12;
            
            // Cálculo de impuestos - cambio requiere modificación aquí
            double federalTax = annualSalary * 0.22;
            double stateTax = annualSalary * 0.05;
            double socialSecurityTax = annualSalary * 0.062;
            double medicareTax = annualSalary * 0.0145;
            
            double totalTaxes = federalTax + stateTax + socialSecurityTax + medicareTax;
            
            // Cálculo de beneficios - cambio requiere modificación aquí
            double healthInsurance = 500;
            double dentalInsurance = 50;
            double visionInsurance = 25;
            double lifeInsurance = 100;
            double retirement401k = annualSalary * 0.06;
            
            double totalBenefits = healthInsurance + dentalInsurance + visionInsurance + lifeInsurance + retirement401k;
            
            // Cálculo de bonificación - cambio requiere modificación aquí
            double bonus = 0;
            if (emp.getPerformanceScore() > 4.0) {
                bonus = monthlySalary * emp.getBonusPercentage();
            }
            
            // Cálculo de comisión - cambio requiere modificación aquí
            double commission = 0;
            if (emp.getDepartment().equals("Sales")) {
                commission = monthlySalary * 0.15;
            }
            
            // Neto final
            double netPay = monthlySalary + bonus + commission - totalBenefits - totalTaxes;
            
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Monthly Salary: $" + monthlySalary);
            System.out.println("Bonus: $" + bonus);
            System.out.println("Commission: $" + commission);
            System.out.println("Total Taxes: $" + totalTaxes);
            System.out.println("Total Benefits: $" + totalBenefits);
            System.out.println("Net Pay: $" + netPay);
            System.out.println("---");
        }
    }
    
    // SMELL: Shotgun Surgery - Método similar al anterior
    // Cambios en lógica afectan ambos métodos
    public void processAnnualPayroll() {
        for (Employee emp : database.getAllEmployees()) {
            double annualSalary = emp.getSalary() * 12;
            
            double federalTax = annualSalary * 0.22;
            double stateTax = annualSalary * 0.05;
            double socialSecurityTax = annualSalary * 0.062;
            double medicareTax = annualSalary * 0.0145;
            
            double totalTaxes = federalTax + stateTax + socialSecurityTax + medicareTax;
            
            double healthInsurance = 500 * 12;
            double dentalInsurance = 50 * 12;
            double visionInsurance = 25 * 12;
            double lifeInsurance = 100 * 12;
            double retirement401k = annualSalary * 0.06;
            
            double totalBenefits = healthInsurance + dentalInsurance + visionInsurance + lifeInsurance + retirement401k;
            
            double bonus = 0;
            if (emp.getPerformanceScore() > 4.0) {
                bonus = emp.getSalary() * 12 * emp.getBonusPercentage();
            }
            
            double commission = 0;
            if (emp.getDepartment().equals("Sales")) {
                commission = emp.getSalary() * 12 * 0.15;
            }
            
            double netPay = annualSalary + bonus + commission - totalBenefits - totalTaxes;
            
            System.out.println("Employee: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Annual Salary: $" + annualSalary);
            System.out.println("Bonus: $" + bonus);
            System.out.println("Commission: $" + commission);
            System.out.println("Total Taxes: $" + totalTaxes);
            System.out.println("Total Benefits: $" + totalBenefits);
            System.out.println("Annual Net Pay: $" + netPay);
            System.out.println("---");
        }
    }
}