package com.company;

/**
 * SMELL: Primitive Obsession
 * - Usa tipos primitivos donde debería usar objetos
 * - Validaciones primitivas en lugar de clases especializadas
 * - Combinaciones de primitivos que deberían ser Value Objects
 */
public class EmployeeValidator {
    
    // SMELL: Primitive Obsession
    // Estos datos relacionados deberían ser un objeto Contact
    public boolean validateContact(String email, String phone, String alternateEmail, String alternatePhone) {
        boolean emailValid = false;
        boolean phoneValid = false;
        boolean altEmailValid = false;
        boolean altPhoneValid = false;
        
        if (email != null && email.contains("@") && email.contains(".")) {
            emailValid = true;
        }
        
        if (phone != null && phone.length() >= 10) {
            phoneValid = true;
        }
        
        if (alternateEmail != null && alternateEmail.contains("@") && alternateEmail.contains(".")) {
            altEmailValid = true;
        }
        
        if (alternatePhone != null && alternatePhone.length() >= 10) {
            altPhoneValid = true;
        }
        
        return emailValid && phoneValid && altEmailValid && altPhoneValid;
    }
    
    // SMELL: Primitive Obsession
    // Datos de dirección como primitivos, debería ser Address object
    public boolean validateAddress(String street, String city, String state, String country, String zipCode) {
        boolean streetValid = street != null && street.length() > 0;
        boolean cityValid = city != null && city.length() > 0;
        boolean stateValid = state != null && state.length() == 2;
        boolean countryValid = country != null && country.length() > 0;
        boolean zipValid = zipCode != null && zipCode.matches("\\d{5}");
        
        return streetValid && cityValid && stateValid && countryValid && zipValid;
    }
    
    // SMELL: Primitive Obsession
    // Información de compensación como primitivos
    public boolean validateCompensation(double baseSalary, double bonus, double commission, 
                                       double benefits, double deductions) {
        boolean baseSalaryValid = baseSalary > 0;
        boolean bonusValid = bonus >= 0;
        boolean commissionValid = commission >= 0;
        boolean benefitsValid = benefits >= 0;
        boolean deductionsValid = deductions >= 0;
        
        return baseSalaryValid && bonusValid && commissionValid && benefitsValid && deductionsValid;
    }
}