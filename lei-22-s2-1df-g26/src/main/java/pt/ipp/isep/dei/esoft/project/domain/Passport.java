package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.security.*;

public class Passport {
    private String number;
    private String dateOfIssue;
    private String dateOfExpiry;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) //used the regex from this website: https://www.geeksforgeeks.org/how-to-validate-ssn-social-security-number-using-regular-expression/
    {
        String regex = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid passport number.");
        }
        if (!number.matches(regex)) {
            throw new IllegalArgumentException("Invalid passport number.");
        }
        this.number = number;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public Passport(String passportNumber, String passportDateOfIssue, String passportDateOfExpiry) {
    }

}
